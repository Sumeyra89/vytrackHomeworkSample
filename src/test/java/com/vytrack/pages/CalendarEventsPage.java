package com.vytrack.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarEventsPage extends BasePage {

    @FindBy(xpath = "//div[normalize-space()='Options']")
    public WebElement options;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//div[@class ='btn-group'])[2]")
    public WebElement viewPerPage;

}
