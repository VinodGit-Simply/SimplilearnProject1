package TestRunner;

import DriverManager.DriverManager;
import FilerReaderManager.PropertiesReader;

import com.vimalselvam.cucumber.listener.Reporter;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features/pizzahut_test1.feature"},

glue = {"StepDefinitionFiles"},
        //"pretty","html:target/cucumber.html"
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumberreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                //{"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
                //{"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

public class TestRunner {



}
