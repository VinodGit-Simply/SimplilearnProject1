package StepDefinitionFiles;

import DriverManager.DriverManager;
import Hooks.Hooks;
import Util.utility;
import WaitManager.WaitManager;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class test1_SD {

DriverManager dm = new DriverManager();
Hooks hk ;
//WaitManager wm = new WaitManager()
//utility ul ;
public Set<String> winds ;
public String parentwind ;
public static  WebDriver driver;
public String amount_due;
public Double amount_dueValue;
    @Given ("^User launch Pizzahut application with \"(.*)\"$")
    public void launch_url(String URL){
 driver = dm.Driver_Setup();
hk =  new Hooks(driver);
 driver.get(URL);
 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
 //driver.switchTo().alert().accept();
 //driver.switchTo().alert().dismiss();


    }
    @When ("^User wait for auto location black pop up screen$")
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
           popup = driver.findElement
                   (By.xpath("//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']"));
        break;
        }
     }

       Thread.sleep(5000);
     try {
        if (popup != null) {
           popup.click();
        } else {
           driver.findElement
                   (By.xpath("//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']")).click();
        }
     }catch(Exception e)
     {
        System.out.println("Element not found");
     }


    }
    @Then ("^User close the pop up screen And User see pop up for delivery asking for enter location$")
    public void close_popUP()
    {
       System.out.print("pop up did not appear");
    }


    @Then ("^User type address as \"(.*)\"$")
    public void type_Address(String mall_name) throws InterruptedException {
     WebElement suggestions= driver.findElement(By.xpath("//form//div[@class='flex items-stretch']/input[@class='typography-5 search search--hut input border-0 py-15 px-10 min-w-50']"));
     dm.ul.ScrolltoElement(suggestions);
     dm.ul.moveToElement(suggestions);
      suggestions.sendKeys(mall_name);
       WebElement suggestion1 = driver.findElement(By.xpath("//*[contains(text(),'LuLu Mall Hyderabad')]"));
               //driver.findElement(By.xpath("//*[text()='Lulu Mall']"));
       suggestion1.click();
       System.out.println(" values of location suggestions ->"+suggestions.getText());
dm.wm.Sleep(3000);
try {
    driver.findElement(By.xpath("//*[contains(@class,'button button--secondary text-center')]//*[text()='Start your order']")).click();
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

    @When ("^User navigate to deails page$")
    public void navigate_detailsPage() throws InterruptedException {

        dm.wm.Sleep(1000);
        //driver.findElement(By.xpath("(//div[@class='hut-option mr-10'])[1]")).click();
        try {
            driver.findElement(By.xpath("//div[@data-testid='button-select-collection'][3]")).click();
        }catch(Exception e){
            System.out.println("\n"+"Element not found during this time ..");
        }
    }

    @Then ("^User validate vegetarian radio button flag is off$")
    public void validate_VegetarianRadioButton(){
dm.wm.PageLoad_Wait(Duration.ofSeconds(3));
WebElement radiobutton_disable = driver.findElement(By.xpath("(//div[@role='button']//span[@class='py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start'])[2]"));
        Assert.isTrue(radiobutton_disable.isDisplayed()," message validation");
        System.out.println("vegetario button is -->"+radiobutton_disable.isDisplayed());
    }

    @And ("^User clicks on Pizzas menu bar option$")
    public void PizzaMenu() throws InterruptedException {
        dm.wm.Sleep(1000);
driver.findElement(By.xpath("//a[@class='typography-4 side-menu__link side-menu__link--pizzas text-white lg:text-black  capitalize lg:border-r']")).click();
    }

    @When ("^User select add button of any pizza from Recommended$")
    public void add_Pizza() throws InterruptedException {

        dm.ul.ScrolltoElement(driver.findElement(By.xpath("//h2[@class='typography-2 capitalize my-20 mx-10 text-center heading-hr']")));
        dm.wm.Sleep(1000);
        WebElement pizza = driver.findElement(By.xpath("//div[@class='typography-4 list-item__name flex-1 px-10 pt-10'][text()='Chicken Sausage']"));
        dm.ul.ScrolltoElement(pizza);
        WebElement add_pizza = driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])[18]"));
        dm.ul.ScrolltoElement(add_pizza);
        add_pizza.click();
        //pizza.click();
    }

    @Then ("^User see that the pizza is getting added under Your Basket$")
    public void validate_AddPizaa(){

        dm.wm.wait_implicit(Duration.ofSeconds(2));
        WebElement basket = driver.findElement(By.xpath("//*[contains(text(),'Your Basket')]"));
        dm.ul.moveToElement(basket);
        WebElement basket_pizza = driver.findElement(By.xpath("//*[contains(text(),'Personal Chicken Sausage')]"));
        dm.ul.moveToElement(basket_pizza);
        System.out.println("Pizza added -->"+basket_pizza.isDisplayed());
        dm.wm.wait_implicit(Duration.ofSeconds(2));
    }

    @And ("^User validate pizza price plus Tax is checkout price$")
    public void validate_PizzaPrice(){

        WebElement SubTOTAL = driver.findElement(By.xpath("//*[@class='subtotal']"));
        dm.ul.moveToElement(SubTOTAL);
        String subtotal = SubTOTAL.getText().toString();
        subtotal = subtotal.substring(1,subtotal.length());
        Double subtotal_value = Double.parseDouble(subtotal);
       // Double subtotal_value = (double) Integer.parseInt(subtotal);
        Double restaraunt_handling_charges;
        try {
            String rhc = driver.findElement(By.xpath("//*[@class='display-supplement-value']")).getText().toString();
            rhc = rhc.substring(1, rhc.length());
            restaraunt_handling_charges = Double.parseDouble(rhc);
        }catch(Exception e){
            restaraunt_handling_charges = 0.0;
            System.out.println("restaurant handling carges are not present and hence it is made ZERO ..");
        }
        String total_tax = driver.findElement(By.xpath("(//div[@class='flex flex-col pt-15 bg-white']//span)[4]")).getText().toString();
        total_tax = total_tax.substring(1,total_tax.length());
        Double tax =  Double.parseDouble(total_tax);

       Double total_due = (subtotal_value+restaraunt_handling_charges+tax);

         amount_due = driver.findElement(By.xpath("//span[@class='amountdue']")).getText();
         amount_due = amount_due.substring(1,amount_due.length());
         amount_dueValue = Double.parseDouble(amount_due);

         System.out.println("AmountDue on the Web ->"+amount_dueValue+"  "+"Total Due Calculated -->"+total_due);



    }

    @Then ("^User validate checkout button contains Item count$")
    public  void  validate_checkout_Button_itemcount() throws InterruptedException {

        WebElement item_count = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
        item_count.isDisplayed();
        String itemcount1 = item_count.getText().toString();
        System.out.println(" item count is displayed -->" + itemcount1.contains("item"));
        dm.wm.Sleep(2000);
    }

    @And ("^User validate checkout button contains total price count$")
    public void validate_checkout_totalPrice(){

        WebElement Checkout_Price = driver.findElement(By.xpath("//span[@class='ml-auto text-right']/span"));

        String CheckoutPrice = Checkout_Price.getText().toString();

        System.out.println( "CheckOut Button has value ->"+ CheckoutPrice + "total amount due calculated ->"+ amount_dueValue);


    }

    @Then ("^User clicks on Drinks option$")
    public void validate_clickDrink() throws InterruptedException {


       dm.wm.wait_implicit(Duration.ofSeconds(1));
        driver.findElement(By.xpath("//button[@class='basket-upsell-carousel-scroll-btn basket-upsell-carousel-right-btn']")).click();
        dm.wm.Sleep(2000);
        driver.findElement(By.xpath("//button[@class='basket-upsell-carousel-scroll-btn basket-upsell-carousel-right-btn']")).click();
        dm.wm.wait_implicit(Duration.ofSeconds(1));



    }

    @And ("^User select Pepsi option to add into the Basket$")
    public void select_Pepsi(){
        dm.ul.moveToElement(driver.findElement(By.xpath("//*[@class='basket-upsell-carousel-container']")));
        dm.wm.wait_implicit(Duration.ofSeconds(2));
        driver.findElement(By.xpath("//*[contains(text(),'Pepsi - 475ml')]")).click();

        dm.wm.wait_implicit(Duration.ofSeconds(2));
        WebElement basket = driver.findElement(By.xpath("//*[contains(text(),'Your Basket')]"));
        dm.ul.moveToElement(basket);
        dm.wm.wait_implicit(Duration.ofSeconds(1));
        WebElement pepsi = driver.findElement(By.xpath("//*[contains(text(),'Pepsi - 475ml')]"));

        dm.ul.ScrolltoElement(pepsi);
        dm.wm.wait_implicit(Duration.ofSeconds(1));
        System.out.println("is Pepsi Displayed -->"+ pepsi.isDisplayed() + "value of item :"+ pepsi.getText());




    }

    @Then ("^User see 2 items are showing under checkout button$")
    public void validate_checkout_2Items(){

        WebElement items_verify = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));

        if (items_verify.getText().toString().equals("2 items")){
            System.out.println("Checkout item Count :->" + items_verify.getText().toString());
        }


    }

    @And ("^User see total price is now more than before$")
    public void total_Price_MoreThan(){


        WebElement Checkout_Price2 = driver.findElement(By.xpath("//span[@class='ml-auto text-right']/span"));

        String CheckoutPrice2 = Checkout_Price2.getText().toString();
        CheckoutPrice2 = CheckoutPrice2.substring(1,CheckoutPrice2.length());

        Double CheckoutPrice2_Value = Double.parseDouble(CheckoutPrice2);

        if (CheckoutPrice2_Value > amount_dueValue) {
            System.out.println("CheckOut Button has new value ->" + CheckoutPrice2_Value + "total amount due calculated previously which was ->" + amount_dueValue);
        }

    }

    @Then ("^User remove the Pizza item from Basket$")
    public void Remove_PizzaItem() throws InterruptedException {

        dm.wm.wait_implicit(Duration.ofSeconds(2));
        WebElement basket = driver.findElement(By.xpath("//*[contains(text(),'Your Basket')]"));
        dm.ul.moveToElement(basket);
        dm.wm.Sleep(1000);
        WebElement pizza = driver.findElement(By.xpath("//*[@class='basket-item-product-edit-button absolute inset-0 cursor-pointer screenreader-only']"));
        dm.ul.ScrolltoElement(pizza);
        WebElement remove_pizza = driver.findElement(By.xpath("(//button[@class='icon-close relative opacity-25 text-grey ml-10 p-10'])[1]"));
        dm.ul.ScrolltoElement(remove_pizza);
        remove_pizza.click();
    }

    @And ("^see Price tag got removed from the checkout button$")
    public void remove_PriceTage(){

        //WebElement Checkout_PriceTAg = driver.findElement(By.xpath("//span[@class='ml-auto text-right']/span"));
        dm.wm.WaitforElementNotVisible(By.xpath("//span[@class='ml-auto text-right']/span"));

        //dm.wm.waitforInvisibility(Checkout_PriceTAg);
    }

    @And ("^User see 1 item showing in checkout button$")
    public void validate_OneItem() throws InterruptedException {

        WebElement item_count = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
        item_count.isDisplayed();
        String itemcount1 = item_count.getText().toString();
        System.out.println(" item count is displayed -->" + itemcount1.contains("1 item"));
        dm.wm.Sleep(2000);

    }

    @Then ("^User Clicks on Checkout button$")
    public void click_Checkout(){
dm.wm.wait_implicit(Duration.ofSeconds(1));
        driver.findElement(By.xpath("(//span[@class='absolute inset-0 flex-center']/span)[2]")).click();

    }

    @And ("^User see minimum order required pop up is getting displayed$")
    public void min_OrderRequired(){

        dm.wm.wait_implicit(Duration.ofSeconds(1));
        WebElement Order_error_message = driver.findElement(By.xpath("//*[contains(text(),'minimum delivery spend')]"));
        System.out.println("The order delivery error message upon clicking on CHECKOUT button"+Order_error_message);
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
