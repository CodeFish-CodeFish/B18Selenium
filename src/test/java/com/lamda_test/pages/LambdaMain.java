package com.lamda_test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

public class LambdaMain {

    public LambdaMain(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Input Form Submit')]")
    WebElement inputForm;

    public void clickOnInputForm(){
        inputForm.click();
    }


    @FindBy(xpath = "//a[.='Ajax Form Submit']")
    WebElement ajaxSubmitForm;

    public void clickOnAjaxForm(){

        ajaxSubmitForm.click();
    }



}
