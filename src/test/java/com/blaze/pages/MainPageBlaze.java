package com.blaze.pages;

import com.qa_fox.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class MainPageBlaze {

    public MainPageBlaze(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Laptops')]")
    WebElement laptopsTab;

    public void clickOnLaptopTab(){
        BrowserUtils.clickOnElement(laptopsTab);
    }


}
