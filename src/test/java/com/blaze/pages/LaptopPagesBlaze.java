package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPagesBlaze {

    public LaptopPagesBlaze(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[@class='card-title']")
    List<WebElement> allLaptops;

    public void chooseLaptop(WebDriver driver, String brandName) throws InterruptedException {

        for (int i = 0; i < allLaptops.size(); i++) {

            if (BrowserUtils.getText(allLaptops.get(i)).equals(brandName)) {
                BrowserUtils.scrollWithPoint(driver, allLaptops.get(i));
                Thread.sleep(1000);
                BrowserUtils.clickOnElement(allLaptops.get(i));
                break;
            }

        }

    }


}
