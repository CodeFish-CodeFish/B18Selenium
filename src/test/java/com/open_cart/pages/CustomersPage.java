package com.open_cart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CustomersPage {

    public CustomersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#collapse-5']")
    WebElement customerTab;

    @FindBy(xpath = "//a[.='Customers']")
    WebElement subCustomerTab;

    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> allCustomerNames;


    public void getNames(){

        customerTab.click();
        subCustomerTab.click();
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < allCustomerNames.size(); i++) {
            names.add(allCustomerNames.get(i).getText());
        }
        System.out.println(names);

    }
}
