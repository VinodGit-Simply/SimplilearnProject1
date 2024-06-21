package TestNGTest;

import Util.utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;



public class Listeners  implements ITestListener {


    ExtentTest test ;
    ExtentReports extent = ExtentReportConfig.getExtentReportConfig();
    public WebDriver driver;
    utility ul ;
    screenshotpath sp;
   public Listeners() {
      sp = new screenshotpath();

   }


    @Override
    public void onTestStart(ITestResult result){

        test = extent.createTest(result.getMethod().getMethodName());


    }

    @Override
    public void onTestSuccess(ITestResult result) {

        //ITestListener.super.onTestSuccess(result);
        test.log(Status.PASS,"Test is passed");
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
            //test.addScreenCaptureFromBase64String(sp.getScreenshotPath(result.getMethod().getMethodName(),driver));
            Thread.sleep(2000);
            test.addScreenCaptureFromPath(sp.getScreenshotPath(result.getMethod().getMethodName(),driver));
            Thread.sleep(2000);
        } catch (IOException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
      //  ITestListener.super.onTestFailure(result);

        try {
            test.addScreenCaptureFromBase64String(sp.getScreenshotPath(result.getMethod().getMethodName(),driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }


    /**
   // @Override
    public void onStart(ITestContext context) {
        //ITestListener.super.onStart(context);
    }  **/

    @Override
    public void onFinish(ITestContext context) {
      //  ITestListener.super.onFinish(context);
        extent.flush();
    }
}
