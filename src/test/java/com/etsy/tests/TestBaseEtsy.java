package com.etsy.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseEtsy {

    WebDriver driver;

    @BeforeMethod
    public void startUp(){

        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("etsyURL"));

    }


    @AfterMethod
    public void shutDown(ITestResult result){

        if (!result.isSuccess()){
            BrowserUtils.getScreenshot(driver);
        }
        driver.quit();

    }


}
