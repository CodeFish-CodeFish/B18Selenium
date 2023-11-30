package com.luma.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class LumaBase {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("lumaURL"));
    }

}
