package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class RegisterAccount {

    public RegisterAccount(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;

    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-telephone")
    WebElement phone;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement passwordConfirm;


    @FindBy(css = "label[class='radio-inline']")
    List<WebElement> radios;

    @FindBy(css = "input[type='checkbox']")
    WebElement checkBox;

    @FindBy(css = "input[type='submit']")
    WebElement continueBtn;

    public void fillInfo(String firstName, String lastName, String email,
                         String phone, String password, String passwordConfirm) throws InterruptedException {

        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.phone.sendKeys(phone);
        this.password.sendKeys(password);
        this.passwordConfirm.sendKeys(passwordConfirm);
        Thread.sleep(2000);
        for (int i = 0; i < radios.size(); i++) {

            if (BrowserUtils.getText(radios.get(i)).equalsIgnoreCase("yes")){
                radios.get(i).click();
            }
        }
        Thread.sleep(2000);
        checkBox.click();

        continueBtn.click();
    }

}
