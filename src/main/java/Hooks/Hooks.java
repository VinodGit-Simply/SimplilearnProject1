package Hooks;

import DriverManager.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

public static WebDriver driver;

    public Hooks(WebDriver driver) {
        this.driver = driver;
    }



    @AfterStep
    public void addScreenshot(Scenario scenario){

        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());

    }

}


