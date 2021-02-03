package com.vytrack.tests;

import com.vytrack.pages.CalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class VytrackHomeworkClass extends TestBase {


    @Test
    public void optionsIsDisplayed() {
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
        Assert.assertTrue(new CalendarEventsPage().options.isDisplayed(), "verify options is displayed");

        extentLogger.pass("PASS: Options is displayed test");
    }

    @Test
    public void pageNumberTest() {
        extentLogger = report.createTest("Page Number is equals to 1 Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("username : " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("password : " + ConfigurationReader.get("storemanager_password"));
        extentLogger.info("login as a store manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("go to the Activities ---> Calendar Events");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        extentLogger.info("Verify the page number is 1");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        assertEquals(calendarEventsPage.pageNumber.getAttribute("value"), "1", "verify the page number");
        extentLogger.pass("PASS: Page Number is equals to 1 Test");

    }

    @Test
    public void viewPerPageTest() {
        extentLogger = report.createTest("View Per Page equals to 25 Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("username : " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("password : " + ConfigurationReader.get("storemanager_password"));
        extentLogger.info("login as a store manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("go to the Activities ---> Calendar Events");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        extentLogger.info("verify the view per page is 25");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        assertEquals(new CalendarEventsPage().viewPerPage.getText(), "25", "verify the view per page is 25");

        extentLogger.pass("PASS: View Per Page equals to 25 Test");
    }

    @Test
    public void equalsToRecordsTest() {
        extentLogger = report.createTest("Number of calendar events equal to number of records test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("username : " + ConfigurationReader.get("storemanager_username"));
        extentLogger.info("password : " + ConfigurationReader.get("storemanager_password"));
        extentLogger.info("login as a store manager");
        loginPage.loginAsStoreManager();

        extentLogger.info("go to the Activities ---> Calendar Events");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        extentLogger.info("find the number of the total rows on grid page by page");
        new DashboardPage().waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(10);

    }

}
