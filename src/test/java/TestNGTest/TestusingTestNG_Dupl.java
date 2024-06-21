package TestNGTest;

import PageObjectClasses.HomePage;
import PageObjectClasses.MenuPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestusingTestNG_Dupl extends BaseTest{
   // public WebDriver driver;

    ExtentReports extent1 = ExtentReportConfig.getExtentReportConfig();
    ExtentTest test1 ;
    screenshotpath sp1;
    public WebDriver driver1;
public static String mall_name ;
   public TestusingTestNG_Dupl() {

    }

    @DataProvider(name="testdata")
    public Object[][] getTestData() throws IOException {
        return em.getExcelTestData();
    }

/**
  //  @DataProvider(name="testdata1")
    public Object[] getTestData1() throws IOException {
        return em.getExcelData1();
    }
    **/

/**
  //  @DataProvider(name="testdata2")
    public Object[] getTestData2() throws IOException {
        return em.getExcelData2();
    }
**/


//@Parameters({"URL"})


    @Test(priority = 0,dataProvider = "testdata")
    public void launch_url(String URL,String mall) throws IOException {

        test1 = extent1.createTest("launch_url");
       System.out.print("the value of URL from the EXCEL sheet"+URL );
        driver.get(URL);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        //driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();

       mall_name = mall;

       test1.pass("test pass");
       sp1 = new screenshotpath();
       driver1 = driver;
       String path = sp1.getScreenshotPath1(driver1);
       test1.addScreenCaptureFromBase64String(path);
       extent1.flush();
    }

    @Test(priority = 1)
    public void Handle_popup() throws InterruptedException {
        hom.popUp();
    }
    @Test(priority = 2)
    public void close_popup() throws Exception{
        hom.close_popUP();
        hom.type_Address(mall_name);
    }

    @Test(priority = 3)
    public void navigate_detailsPage() throws InterruptedException {
        hom.navigate_detailsPage();
    }

    @Test(priority = 4)
    public void validate_VegetarianRadioButton(){
        hom.validate_VegetarianRadioButton();
    }

    @Test(priority = 5)
    public void Pizza_Menu() throws InterruptedException {

        hom.PizzaMenu();
    }

    @Test(priority = 6)
    public void addPizaa() throws InterruptedException {
        mp.add_Pizza();
    }

    @Test(priority = 7)
    public void validate_addingPizza(){
        mp.validate_AddPizaa();
    }

    @Test(priority = 8)
    public void validatePizzaPrice(){
        mp.validate_PizzaPrice();
    }

    @Test(priority = 9)
    public void validate_checkout_Button_itemcount() throws InterruptedException {
        mp.validate_checkout_Button_itemcount();
    }

    @Test(priority = 10)
    public void validate_checkout_totalPrice(){
        mp.validate_checkout_totalPrice();
    }

    @Test(priority =11)
    public void validate_clickDrink() throws InterruptedException {
        mp.validate_clickDrink();
    }

    @Test(priority = 12)
    public void select_Pepsi(){

        mp.select_Pepsi();
    }

    @Test(priority = 13)
    public void checkout_validateItems(){
        mp.validate_checkout_2Items();
    }

    @Test(priority = 14)
    public void total_PriceMoreThan(){
        mp.total_Price_MoreThan();
    }

    @Test(priority = 15)
    public void remove_PizzaItem() throws InterruptedException {
        mp.Remove_PizzaItem();
    }

    @Test(priority = 16)
    public void remove_PriceTage(){
        mp.remove_PriceTage();
    }

    @Test(priority = 17)
    public void validate_OneItem() throws InterruptedException {
        mp.validate_OneItem();
    }

    @Test(priority = 18)
    public void click_CheckOUT(){
        mp.click_Checkout();
    }

    @Test(priority = 19)
    public void min_OrderRequired(){
        mp.min_OrderRequired();
    }


}
