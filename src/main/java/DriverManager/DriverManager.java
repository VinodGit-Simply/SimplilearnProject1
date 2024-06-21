package DriverManager;

import Util.utility;
import WaitManager.WaitManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    public static WebDriver driver ;
    public utility ul;
    public  WaitManager wm;
 public WebDriver Driver_Setup(){

     WebDriverManager.chromedriver().setup();

     ChromeOptions chromeOpt = new ChromeOptions();

     chromeOpt.addArguments("--start-maximized");
     chromeOpt.addArguments("--disable-infobars");
     chromeOpt.addArguments("--incognito");

     /** this is for location popup handling ***/
     Map< String, Object > prefs = new HashMap< String, Object >();
     Map < String, Object > profile = new HashMap < String, Object > ();
     Map < String, Object > contentSettings = new HashMap < String, Object > ();

     // SET CHROME OPTIONS
     // 0 - Default, 1 - Allow, 2 - Block
     contentSettings.put("geolocation", 1);
     profile.put("managed_default_content_settings", contentSettings);
     prefs.put("profile", profile);
     chromeOpt.setExperimentalOption("prefs", prefs);

     /**********************/

     driver = new ChromeDriver(chromeOpt);
     driver.manage().deleteAllCookies();
     ul = new utility(driver);
     wm = new WaitManager(driver);



     return driver;
 }

}
