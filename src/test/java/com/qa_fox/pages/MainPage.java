package com.qa_fox.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md']")
    List<WebElement> allTabs;

    @FindBy(xpath = "//p[contains(.,'Qafox.com © 2023')]")
    WebElement footer;

    @FindBy(css = "input[name='search']")
    WebElement searchBar;

    @FindBy(xpath = "//a[.='Desktops']")
    WebElement desktopTab;

    @FindBy(xpath = "//a[.='Show AllDesktops']")
    WebElement showAllDesktops;



    public void validateMainPage(WebDriver driver, String testData) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(allTabs.get(i).isDisplayed());
            System.out.println(BrowserUtils.getText(allTabs.get(i)));
        }
        BrowserUtils.scrollWithPoint(driver, footer);
        Thread.sleep(2000);
        BrowserUtils.scrollWithPoint(driver, searchBar);
        //searchBar.sendKeys(testData, Keys.ENTER);
    }

    public void clickOnDesktop(WebDriver driver){

        BrowserUtils.hoverOver(driver, desktopTab);

        BrowserUtils.clickOnElement(showAllDesktops);


    }




}
