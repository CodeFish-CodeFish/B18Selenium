package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductListLuma {

    WebDriver driver;

    public ProductListLuma(WebDriver driver){
        this.driver = driver;
    }

    private By secondBag = By.xpath("//a[contains(.,'Overnight Duffle')]");

////li[2]//span[contains(.,'Add to Cart')]

    ////a[contains(.,'Overnight Duffle')]//..//following-sibling::div//form//button[@type='submit']

    private By addToCardBag = By.xpath("//li[2]//span[contains(.,'Add to Cart')]");

    private By myCart = By.cssSelector("a[class='action showcart']");

    private By proceedToCheckOut = By.cssSelector("#top-cart-btn-checkout");


    public WebElement secondBagHoverOver(){
        return driver.findElement(secondBag);
    }

    public WebElement addToCardBagBtn(){
        return driver.findElement(addToCardBag);
    }

    public WebElement clickOnMyCart(){
        return driver.findElement(myCart);
    }

    public WebElement proceedToCheckOutLink(){
        return driver.findElement(proceedToCheckOut);
    }




}
