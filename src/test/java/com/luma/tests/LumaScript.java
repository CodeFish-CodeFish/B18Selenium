package com.luma.tests;

import com.luma.pages.LumaMain;
import com.luma.pages.ProductListLuma;
import com.luma.pages.Shipping;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserUtils;

public class LumaScript extends LumaBase{

    @Parameters({"email", "firstName", "lastName", "address", "city", "state", "zipCode", "phone",
                 "methodName"})

    @Test
    public void validatePurchase(String email, String firstName, String lastName,
                                 String address, String city,String state, String zipCode,String phone,
                                 String methodName) throws InterruptedException {
        LumaMain lumaMain = new LumaMain(driver);
        BrowserUtils.hoverOver(driver, lumaMain.hoverOverGear());
        Thread.sleep(2000);
        lumaMain.clickOnBags().click();
        Thread.sleep(2000);

        ProductListLuma productListLuma = new ProductListLuma(driver);
        BrowserUtils.hoverOver(driver,productListLuma.secondBagHoverOver());
        Thread.sleep(1000);
        productListLuma.addToCardBagBtn().click();

        Thread.sleep(3000);
        productListLuma.clickOnMyCart().click();
        Thread.sleep(2000);
        productListLuma.proceedToCheckOutLink().click();

        Shipping shipping = new Shipping(driver);

        shipping.emailField().sendKeys(email);
        shipping.firstNameField().sendKeys(firstName);
        shipping.lastNameField().sendKeys(lastName);
        shipping.addressField().sendKeys(address);
        shipping.cityField().sendKeys(city);
        BrowserUtils.selectBy(shipping.dropDownState(), state, methodName);
        shipping.zipCodeField().sendKeys(zipCode);
        shipping.phoneField().sendKeys(phone);
        shipping.flatRateCheckBox().click();
        shipping.nextBtn().click();


    }
}
