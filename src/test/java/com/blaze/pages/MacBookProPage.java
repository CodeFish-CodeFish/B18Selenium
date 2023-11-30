package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class MacBookProPage {

    public MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2")
    WebElement macbookHeader;

    @FindBy(xpath = "//h3")
    WebElement price;

    @FindBy(css = "div[id='more-information']")
    WebElement description;

    @FindBy(css = "a[onclick='addToCart(15)']")
    WebElement addToCartBtn;

    @FindBy(css = "a[id='cartur']")
    WebElement cartLink;

    public void validateAndAddMacBook(WebDriver driver) throws InterruptedException {

        Assert.assertTrue(macbookHeader.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(description.isDisplayed());
        BrowserUtils.clickOnElement(addToCartBtn);
        Thread.sleep(2000);
        BrowserUtils.acceptAlert(driver);
        BrowserUtils.clickWithJS(driver, cartLink);
    }

}
