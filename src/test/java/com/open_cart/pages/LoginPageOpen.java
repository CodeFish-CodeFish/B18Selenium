package com.open_cart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOpen {

    public LoginPageOpen(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;

    public void login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginBtn.click();

    }
}
