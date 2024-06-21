package TestNGTest;

import DriverManager.DriverManager;
import ExcelManger.ExcelManagerClass;
import PageObjectClasses.HomePage;
import PageObjectClasses.MenuPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Hooks.Hooks;

public class BaseTest {

    public static WebDriver driver;
    DriverManager dm = new DriverManager();
    public static ExcelManagerClass em;
    Hooks hk;
  public static HomePage hom;
  public static MenuPage mp;
    @BeforeSuite
    public void Driver_Launch_URL(){
        driver = dm.Driver_Setup();
        hk =  new Hooks(driver);
        hom = new HomePage(driver);
        mp = new MenuPage(driver);
       em = new ExcelManagerClass();

    }

    @AfterSuite
    public  void Tear_Down(){
        driver.quit();}

}
