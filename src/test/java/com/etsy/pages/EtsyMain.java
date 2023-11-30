package com.etsy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class EtsyMain {

    WebDriver driver;

    public EtsyMain(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBar;

    public void sendKeysToSearchBar(String key){

        searchBar.sendKeys(key, Keys.ENTER);

    }




}
