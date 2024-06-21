package PageObjectClasses;

import Hooks.Hooks;
import Util.utility;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import WaitManager.WaitManager;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.By.xpath;

public class HomePage{


public Set<String> winds ;
public String parentwind ;
public static WebDriver driver;
public  utility ul ;
Hooks hk ;
WaitManager wm ;

public  HomePage(WebDriver driver) {
     this.driver = driver;
     ul = new utility(driver);
     wm = new WaitManager(driver);
    PageFactory.initElements(driver,this);
}

@FindBy (xpath="//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']") WebElement popup;

By Click = By.xpath("//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']");

By Suggestion = By.xpath("//form//div[@class='flex items-stretch']/input[@class='typography-5 search search--hut input border-0 py-15 px-10 min-w-50']");
By Suggestion1 = By.xpath("//*[contains(text(),'LuLu Mall Hyderabad')]");
By start_order = By.xpath("//*[contains(@class,'button button--secondary text-center')]//*[text()='Start your order']");
By navigate = By.xpath("//div[@data-testid='button-select-collection'][3]");
By vegetarian = By.xpath("(//div[@role='button']//span[@class='py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start'])[2]");

By pizza = By.xpath("//a[@class='typography-4 side-menu__link side-menu__link--pizzas text-white lg:text-black  capitalize lg:border-r']");

public void popUp() throws InterruptedException {

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       parentwind = driver.getWindowHandle();
       winds =  driver.getWindowHandles();
       WebElement popup = null;
     for(String s : winds) {
        System.out.println("Window Handles :" + s);
        if (!(s.equals(parentwind))) {
           driver.switchTo().window(s);
           System.out.println("Inside desired window :->" + s);

        break;
        }
     }

       Thread.sleep(5000);
     try {
        if (popup != null) {
           popup.click();
        } else {
           driver.findElement
                   (Click).click();
        }
     }catch(Exception e)
     {
        System.out.println("Element not found");
     }


    }
    //Then ("^User close the pop up screen And User see pop up for delivery asking for enter location$")
    public void close_popUP()
    {
       System.out.print("pop up did not appear");
    }


    //Then ("^User type address as \"(.*)\"$")
    public void type_Address(String mall_name) throws InterruptedException {
     WebElement suggestions= driver.findElement(Suggestion);
     ul.ScrolltoElement(suggestions);
     ul.moveToElement(suggestions);
      suggestions.sendKeys(mall_name);
       WebElement suggestion1 = driver.findElement(Suggestion1);
               //driver.findElement(By.xpath("//*[text()='Lulu Mall']"));
       suggestion1.click();
       System.out.println(" values of location suggestions ->"+suggestions.getText());
wm.Sleep(3000);
try {
    driver.findElement(start_order).click();
} catch(Exception e){
    System.out.println("the Order timing is not displayed this time..");
}
/**
try{
   dm.wm.PageLoad_Wait(Duration.ofSeconds(3));
   WebElement popup_close1= driver.findElement(By.xpath("//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']"));
   dm.wm.wait_implicit(Duration.ofSeconds(1));
   popup_close1.click();
}catch(Exception e){
   System.out.println("Popup element not found here this time");
} **/
    }


    @And ("^User select first auto populate drop down option$")
    public void auto_populate(){

    }

    //When ("^User navigate to deails page$")
    public void navigate_detexitailsPage() throws InterruptedException {

        wm.Sleep(1000);

        //driver.findElement(By.xpath("(//div[@class='hut-option mr-10'])[1]")).click();
        try {
            driver.findElement(navigate).click();
        }catch(Exception e){
            System.out.println("\n"+"Element not found during this time ..");
        }
    }

    //Then ("^User validate vegetarian radio button flag is off$")
    public void validate_VegetarianRadioButton(){
wm.PageLoad_Wait(Duration.ofSeconds(3));
WebElement radiobutton_disable = driver.findElement(vegetarian);
        Assert.isTrue(radiobutton_disable.isDisplayed()," message validation");
        System.out.println("vegetario button is -->"+radiobutton_disable.isDisplayed());
    }

    //And ("^User clicks on Pizzas menu bar option$")
    public void PizzaMenu() throws InterruptedException {
        wm.Sleep(1000);
driver.findElement(pizza).click();
    }



    @AfterStep
    public void addScreenshot(Scenario scenario){

        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");

    }
    @After
    public void tearDown() throws InterruptedException {
       Thread.sleep(5000);
       driver.quit();
    }
}
