package com.etsy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductListPage {

    public ProductListPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h3")
    List<WebElement> allProducts;

    public void getAlliPhones(String cell){

        List<String> iPhones = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {

            if (BrowserUtils.getText(allProducts.get(i)).contains(cell)){

                iPhones.add(BrowserUtils.getText(allProducts.get(i)));

            }

        }
        System.out.println(iPhones);

    }

}
