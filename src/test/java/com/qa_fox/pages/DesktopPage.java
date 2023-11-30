package com.qa_fox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesktopPage {

    public DesktopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#input-sort")
    WebElement sortDropdown;

    @FindBy(css = "#input-limit")
    WebElement sortLimit;


    @FindBy(xpath = "//h4")
    List<WebElement> allProducts;


    public void validateProducts(String value, String methodName, String value2, String value3) throws InterruptedException {

        Thread.sleep(2000);
        BrowserUtils.selectBy(sortDropdown, value,methodName);
        BrowserUtils.selectBy(sortLimit, value2, methodName);

        ArrayList<String> AtoZ = new ArrayList<>();
        ArrayList<String> ZtoA = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {
            AtoZ.add(BrowserUtils.getText(allProducts.get(i)));
        }

        Thread.sleep(2000);

        BrowserUtils.selectBy(sortDropdown, value3,methodName);
        BrowserUtils.selectBy(sortLimit, value2, methodName);

        for (int i = 0; i < allProducts.size(); i++) {

            ZtoA.add(BrowserUtils.getText(allProducts.get(i)));

        }
        Assert.assertNotEquals(AtoZ, ZtoA);

    }

}
