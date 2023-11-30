package com.qa_fox.tests;

import com.qa_fox.pages.DesktopPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class DesktopPageTest {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=product/category&path=20");
    }

    @Test
    public void TC_02() throws InterruptedException {

        DesktopPage desktopPage = new DesktopPage(driver);
        desktopPage.validateProducts("Name (A - Z)", "visibleText","100","Name (Z - A)");

    }
}
