package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    @FindBy(xpath = "//td[contains(.,'MacBook Pro')]")
    WebElement macbookText;


    @FindBy(xpath = "//td[contains(.,'1100')]")
    WebElement price;

    @FindBy(xpath = "//td[contains(.,'Delete')]")
    WebElement deleteBtn;

    @FindBy(xpath = "//button[contains(.,'Place Order')]")
    WebElement placeOrderBtn;


    // below xpath will be used to fill customer information
    @FindBy(css = "#name")
    WebElement customerName;

    @FindBy(css = "#country")
    WebElement customerCountry;

    @FindBy(css = "#city")
    WebElement customerCity;

    @FindBy(css = "#card")
    WebElement cc;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[contains(.,'Purchase')]")
    WebElement purchaseBtn;

    @FindBy(xpath = "//h2[contains(.,'Thank you for your purchase!')]")
    WebElement thxMsg;

    @FindBy(xpath = "//button[contains(.,'OK')]")
    WebElement okBtn;


    public void validatePurchaseFunctionality(String customerName, String customerCountry, String customerCity, String cc,
                                              String month, String year, String thxMsg) throws InterruptedException {

        Assert.assertTrue(macbookText.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(deleteBtn.isDisplayed());
        Thread.sleep(2000);
        placeOrderBtn.click();
        this.customerName.sendKeys(customerName);
        this.customerCountry.sendKeys(customerCountry);
        this.customerCity.sendKeys(customerCity);
        this.cc.sendKeys(cc);
        this.month.sendKeys(month);
        this.year.sendKeys(year);
        BrowserUtils.clickOnElement(purchaseBtn);
        Assert.assertEquals(BrowserUtils.getText(this.thxMsg),thxMsg);
        BrowserUtils.clickOnElement(okBtn);

    }







}
