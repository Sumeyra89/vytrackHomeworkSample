package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "prependedInput")
    public WebElement userNameInputBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInputBox;

    @FindBy(id = "_submit")
    public WebElement submitButton;

    public void loginAsStoreManager(){
        userNameInputBox.sendKeys(ConfigurationReader.get("storemanager_username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("storemanager_password"));
        submitButton.click();
    }

}
