package com.vytrack.tests;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackHomeworkClass extends TestBase {


    @Test
    public void optionsIsDisplayed(){
        extentLogger = report.createTest("Options is displayed Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("username : " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("password : " + ConfigurationReader.get("storemanager_password"));
        extentLogger.info("login as a store manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("go to the Activities ---> Calendar Events");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify Options is Displayed");
        Assert.assertTrue(new CalendarEventsPage().options.isDisplayed(),"verify options is displayed");

        extentLogger.pass("PASS: Options is displayed test");



    }


}
