package TestNGTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfig {


public static  ExtentReports exr;
     public static ExtentReports getExtentReportConfig() {
         String report_path = System.getProperty("user.dir") + "\\reports\\index.html";

         ExtentSparkReporter esr = new ExtentSparkReporter(report_path);

         esr.config().setReportName("SimplieLearnProjectAssignment");
         esr.config().setDocumentTitle("TestResults");

         exr = new ExtentReports();
         exr.attachReporter(esr);
         exr.setSystemInfo("test_vinod","projet");

         return exr;

     }

}
