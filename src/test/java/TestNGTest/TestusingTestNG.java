package TestNGTest;

import PageObjectClasses.HomePage;
import PageObjectClasses.MenuPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;



public class TestusingTestNG extends BaseTest {
    // public WebDriver driver;

   // HomePage hom;
   // MenuPage mp;



    @Parameters({"URL"})
    @Test
    public void launch_url(String URL) throws InterruptedException {


        driver.get(URL);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        //driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();

    }
    @Test(priority = 1)
    public void popup_test() throws InterruptedException {

        hom.popUp();
    }
    @Test(priority =2)
            public void close_popup() throws Exception{
        hom.close_popUP();
        hom.type_Address("lulu mall");

        hom.navigate_detailsPage();

        hom.validate_VegetarianRadioButton();


        hom.PizzaMenu();

        mp.add_Pizza();

        mp.validate_AddPizaa();

        mp.validate_PizzaPrice();

        mp.validate_checkout_Button_itemcount();

        mp.validate_checkout_totalPrice();

        mp.validate_clickDrink();


        mp.select_Pepsi();

        mp.validate_checkout_2Items();

        mp.total_Price_MoreThan();

        mp.Remove_PizzaItem();

        mp.remove_PriceTage();

        mp.validate_OneItem();

        mp.click_Checkout();

        mp.min_OrderRequired();


    }
}