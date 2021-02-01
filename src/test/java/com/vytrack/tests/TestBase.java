package com.vytrack.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected String url;


    @BeforeTest
    public void setUpTest() {
        //initialize the class
        report = new ExtentReports();

        //creaate a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in the report
        htmlReporter.config().setReportName("Vytrack Smoke Test");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }

    @BeforeMethod
    @Parameters("env")
    public void startMethod( @Optional String env) {
        System.out.println("env = " + env);

        //if env variable is null use default url
        if (env == null){
            url=ConfigurationReader.get("url");
        }else{
            url=ConfigurationReader.get(env + "_url");
        }
        //if it is not null, choose env based on value


        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        driver.get(url);



    }

    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void closeMethod(ITestResult result) throws InterruptedException, IOException {
        //if test failed

        if (result.getStatus()==ITestResult.FAILURE){
            //record the name of the failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot

            String screenshotPath = BrowserUtils.getScreenshot(result.getName());
            //add your screen shot to your report
            extentLogger.addScreenCaptureFromPath(screenshotPath);

            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }


        //close driver
        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @AfterTest
    public void tearDownTest() {
        //this is when the report is actually created
        report.flush();

    }
}


