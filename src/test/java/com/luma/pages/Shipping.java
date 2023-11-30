package com.luma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shipping {

    WebDriver driver;

    public Shipping(WebDriver driver){
        this.driver = driver;
    }

    private By email = By.xpath("//div[@class='control _with-tooltip']//input[@type='email']");
  //  private By password = By.cssSelector("#customer-password");
    private By firstName = By.cssSelector("input[name='firstname']");
    private By lastName = By.cssSelector("input[name='lastname']");
    private By address = By.cssSelector("input[name='street[0]']");
    private By city = By.cssSelector("input[name='city']");
    private By dropDown = By.cssSelector("select[name='region_id']");
    private By zipCode = By.cssSelector("input[name='postcode']");
    private By phone = By.cssSelector("input[name='telephone']");
    private By flatRate = By.cssSelector("input[name='ko_unique_2']");
    private By next = By.cssSelector("button[class='button action continue primary']");


    public WebElement emailField(){
        return driver.findElement(email);
    }
//    public WebElement passwordField(){
//        return driver.findElement(password);
//    }
    public WebElement firstNameField(){
        return driver.findElement(firstName);
    }
    public WebElement lastNameField(){
        return driver.findElement(lastName);
    }
    public WebElement addressField(){
        return driver.findElement(address);
    }
    public WebElement cityField(){
        return driver.findElement(city);
    }
    public WebElement dropDownState(){
        return driver.findElement(dropDown);
    }
    public WebElement zipCodeField(){
        return driver.findElement(zipCode);
    }

    public WebElement phoneField(){
        return driver.findElement(phone);
    }
    public WebElement flatRateCheckBox(){
        return driver.findElement(flatRate);
    }

    public WebElement nextBtn(){
        return driver.findElement(next);
    }





}
