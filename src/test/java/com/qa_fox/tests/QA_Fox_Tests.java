package com.qa_fox.tests;

import com.qa_fox.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class QA_Fox_Tests {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
    }

    @Test
    public void TC_01() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.validateMainPage(driver, "Mac Pro");
        mainPage.clickOnDesktop(driver);
    }

}
