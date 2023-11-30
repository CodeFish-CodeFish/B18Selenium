package com.qa_fox.tests;

import com.qa_fox.pages.MainPage;
import com.qa_fox.pages.RegisterAccount;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class QA_Fox_Scripts extends QA_TestBase{

    @Parameters({"firstName", "lastName", "email", "phone", "password", "passwordConfirm"})
    @Test
    public void validateRegister(String firstName, String lastName, String email,
                                 String phone, String password, String passwordConfirm) throws InterruptedException {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnRegister();

        RegisterAccount account = new RegisterAccount(driver);
        account.fillInfo(firstName, lastName, email, phone, password, passwordConfirm);

    }


}
