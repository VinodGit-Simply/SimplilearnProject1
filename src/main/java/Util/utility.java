package Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class utility
{

    public static WebDriver driver;
     Actions action ;
     JavascriptExecutor js ;
    public utility(WebDriver driver){
        this.driver = driver;
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }



    public void ScrolltoElement(WebElement ele){
        action.scrollToElement(ele).build().perform();
    }

    public void ScrollBy(){
        js.executeScript("scrollBy(0,400)");

    }

    public void ScrolltoElement_JS(WebElement ele){

    }

    public void moveToElement(WebElement ele){
        action.moveToElement(ele).build().perform();
    }



}
