package WaitManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public WaitManager(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public void wait_implicit(Duration duration){
        driver.manage().timeouts().implicitlyWait(duration);
    }

    public void PageLoad_Wait(Duration duration){
        driver.manage().timeouts().pageLoadTimeout(duration);
    }

    public void Sleep(long value) throws InterruptedException {
        Thread.sleep(value);
    }

    public void WaitforElementNotVisible(By by1){
         wait.until(ExpectedConditions.invisibilityOfElementLocated(by1));
    }

    public void waitforInvisibility(WebElement ele){
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }
}
