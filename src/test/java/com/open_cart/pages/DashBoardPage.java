package com.open_cart.pages;

import com.blaze.pages.MacBookProPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashBoardPage {

    public DashBoardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn-close")
    WebElement closePopUp;

    @FindBy(xpath = "//div[@class='tile-heading']")
    List<WebElement> allHeaders;

    @FindBy(xpath = "//div[@class='tile-body']")
    List<WebElement> allNumbers;

    public void closePop() throws InterruptedException {
        Thread.sleep(2000);
        closePopUp.click();
    }
    public void validateStatistics(){

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < allHeaders.size(); i++) {
            Assert.assertTrue(allHeaders.get(i).isDisplayed());
            map.put(allHeaders.get(i).getText(), allNumbers.get(i).getText());
        }
        System.out.println(map);

    }
}
