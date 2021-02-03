package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CalendarEventsPage extends BasePage {

    @FindBy(xpath = "//div[normalize-space()='Options']")
    public WebElement options;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//div[@class ='btn-group'])[2]")
    public WebElement viewPerPage;

    @FindBy(xpath = "(//label[@class='dib'])[2]")
    public WebElement numberOfPage;

    @FindBy(css = "i.fa-chevron-right.hide-text")
    public WebElement nextPage;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement record;


    public Integer getNumberOfPages() {
        String[] pages = numberOfPage.getText().split(" ");
        Integer pagesNumber = Integer.parseInt(pages[1]);
        return pagesNumber;
    }

    public String totalRow() {

        Integer totalRow = 0;

        for (int i = 1; i <= getNumberOfPages(); i++) {
            List<WebElement> elements = Driver.get().findElements(By.xpath("//tbody[@class='grid-body']/tr"));

            totalRow += elements.size();

            nextPage.click();
            BrowserUtils.waitFor(2);

        }

        return String.valueOf(totalRow);

    }


}
