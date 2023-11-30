package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class FluentWaitsPractice {

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void showCase1() {

        //Fluent Wait
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeBtn = driver.findElement(By.xpath("//button[contains(.,'Remove')]"));
        removeBtn.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Text On The Page")
                .withTimeout(Duration.ofSeconds(10));
        WebElement message = fluentWait.until(mydriver -> driver.findElement(By.xpath("//p[@id='message']")));

        Assert.assertEquals(BrowserUtils.getText(message), "It's gone!");

        //driver.findElement(By.xpath("//p[@id='message']"));
    }


    @Test
    public void showCase2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        button.click();

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ElementClickInterceptedException.class);

        WebElement inputField = driver.findElement(By.cssSelector("input[type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(inputField)).sendKeys("TEST test");

    }


}
