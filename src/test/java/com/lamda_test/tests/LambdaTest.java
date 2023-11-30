package com.lamda_test.tests;

import com.lamda_test.pages.AjaxSubmitForm;
import com.lamda_test.pages.FillInfoPage;
import com.lamda_test.pages.LambdaMain;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LambdaTest extends LambdaBase{

    @Parameters({"name", "email", "password", "company", "website", "country", "city", "address1",
                 "address2", "state", "zipCode"})

    @Test(priority = 1)
    public void validateFillInInfo(String name, String email, String password, String company,
                                   String website, String country, String city, String address1,
                                   String address2, String state, String zipCode){

        LambdaMain main = new LambdaMain(driver);
        main.clickOnInputForm();

        FillInfoPage infoPage = new FillInfoPage(driver);
        infoPage.fillInForm(name, email, password, company,
                website, country, city, address1, address2, state, zipCode);

    }

    @Parameters({"test", "messageBody"})
    @Test(priority = 2)
    public void validateAjaxForm(String test, String messageBody){

        LambdaMain main = new LambdaMain(driver);
        main.clickOnAjaxForm();

        AjaxSubmitForm ajaxSubmitForm = new AjaxSubmitForm(driver);
        ajaxSubmitForm.inputField.sendKeys(test);
        ajaxSubmitForm.messageArea.sendKeys(messageBody);
        ajaxSubmitForm.submitBtn.click();
    }
}
