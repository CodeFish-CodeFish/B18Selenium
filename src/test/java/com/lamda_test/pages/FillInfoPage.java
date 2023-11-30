package com.lamda_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class FillInfoPage {

    public FillInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#inputEmail4")
    WebElement email;

    @FindBy(css = "#inputPassword4")
    WebElement password;

    @FindBy(css = "#company")
    WebElement company;

    @FindBy(css = "#websitename")
    WebElement website;

    @FindBy(xpath = "//select[@name='country']")
    WebElement countryDropDown;

    @FindBy(css = "#inputCity")
    WebElement city;

    @FindBy(css = "#inputAddress1")
    WebElement address1;

    @FindBy(css = "#inputAddress2")
    WebElement address2;

    @FindBy(css = "#inputState")
    WebElement state;

    @FindBy(css = "#inputZip")
    WebElement zipCode;

    @FindBy(xpath = "//button[.='Submit']")
    WebElement submitBtn;

    public void fillInForm(String name, String email, String password, String company,
                           String website, String country, String city, String address1,
                           String address2, String state, String zipCode){

        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.company.sendKeys(company);
        this.website.sendKeys(website);
        BrowserUtils.selectBy(this.countryDropDown, country, "visibleText");
        this.city.sendKeys(city);
        this.address1.sendKeys(address1);
        this.address2.sendKeys(address2);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
        submitBtn.click();


    }


}
