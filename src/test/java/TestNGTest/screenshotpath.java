package TestNGTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class screenshotpath {

    public  String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
    {

        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        java.util.Date Date =  new java.util.Date();
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+"\\Screenshots\\"+System.currentTimeMillis()+testCaseName+".jpg";
        FileUtils.copyFile(source, new File(destinationFile));
        System.out.println("path of the screenshot :" + destinationFile);
        return destinationFile;
        //1. capture and place in folder //2. extent report pick file and attach to report



    }

    public  static String getScreenshotPath1(WebDriver driver) throws IOException
    {

        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+".png";
        FileUtils.copyFile(source, new File(destinationFile));
        System.out.println("path of the screenshot :" + destinationFile);
        return destinationFile;
        //1. capture and place in folder //2. extent report pick file and attach to report



    }
}
