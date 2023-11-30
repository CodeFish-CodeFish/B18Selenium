package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "input[type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement errorMsg;


    public void validateInvalidEntry(String email, String password, String expectedMessage){
          this.email.sendKeys(email);
          this.password.sendKeys(password);

        BrowserUtils.clickOnElement(submitBtn);

        Assert.assertEquals(BrowserUtils.getText(errorMsg), expectedMessage);
    }


}
