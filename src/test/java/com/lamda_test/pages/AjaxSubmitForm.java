package com.lamda_test.pages;

import com.lamda_test.tests.LambdaBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AjaxSubmitForm {

    public AjaxSubmitForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#title")
    public WebElement inputField;

    @FindBy(how = How.ID, using = "description")
    public WebElement messageArea;

    @FindBy(how = How.ID, using = "btn-submit")
    public WebElement submitBtn;


}
