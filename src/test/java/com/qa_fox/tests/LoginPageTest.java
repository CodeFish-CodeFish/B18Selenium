package com.qa_fox.tests;

import com.qa_fox.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.data_provider.QA_Fox_DataProvider;
import utils.DriverHelper;

public class LoginPageTest {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    }

    @Test(dataProvider = "records", dataProviderClass = QA_Fox_DataProvider.class)
    public void TC_03(String email, String password, String expectedText){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.validateInvalidEntry(email, password, expectedText);

    }
}
