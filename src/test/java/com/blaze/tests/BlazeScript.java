package com.blaze.tests;

import com.blaze.pages.CheckoutPage;
import com.blaze.pages.LaptopPagesBlaze;
import com.blaze.pages.MacBookProPage;
import com.blaze.pages.MainPageBlaze;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class BlazeScript extends TestBase {

    @Test(dataProvider = "mockData", dataProviderClass = DataForBlaze.class)
    public void TC_01(String name, String country, String city,
                      String cc, String month, String year, String thxMsg, String brandName) throws InterruptedException {

        MainPageBlaze mainPageBlaze = new MainPageBlaze(driver);
        mainPageBlaze.clickOnLaptopTab();

        LaptopPagesBlaze lp = new LaptopPagesBlaze(driver);
        lp.chooseLaptop(driver, brandName);

        MacBookProPage mb = new MacBookProPage(driver);
        mb.validateAndAddMacBook(driver);

        CheckoutPage page = new CheckoutPage(driver);
        page.validatePurchaseFunctionality(name, country, city, cc, month, year, thxMsg);

    }

}
