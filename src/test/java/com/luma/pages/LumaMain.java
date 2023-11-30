package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LumaMain {

    WebDriver driver;

    public LumaMain(WebDriver driver){
        this.driver = driver;
    }

    private By gear = By.xpath("//span[.='Gear']");

    private By bags = By.xpath("//span[.='Bags']");

    public WebElement hoverOverGear(){
        return driver.findElement(gear);
    }

    public WebElement clickOnBags(){

        return driver.findElement(bags);
    }



}
