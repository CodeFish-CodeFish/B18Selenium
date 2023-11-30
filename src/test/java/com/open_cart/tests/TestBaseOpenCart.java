package com.open_cart.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class TestBaseOpenCart {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("urlOpenCart"));
    }

    @AfterMethod
    public void shutDown(){
        driver.quit();
    }
}
