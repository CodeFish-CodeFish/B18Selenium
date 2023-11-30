package com.blaze.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBase {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlBlaze"));

    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if (!result.isSuccess()){
            BrowserUtils.getScreenshot(driver);
        }

        driver.quit();

    }
}
