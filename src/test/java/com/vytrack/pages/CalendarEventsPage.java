package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends BasePage{

    @FindBy(xpath = "//div[normalize-space()='Options']")
    public WebElement options;

}
