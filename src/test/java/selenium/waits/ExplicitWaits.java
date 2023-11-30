package selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitWaits {

    /*
    1. Implicit Wait
    2. Explicit Wait -
     */

    @Test
    public void explicitWaitShowCase(){
        WebDriver driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement button = driver.findElement(By.cssSelector("div[id='start']"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//h4[contains(.,'Hello World!')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        text = wait.until(ExpectedConditions.visibilityOf(text));
        System.out.println(BrowserUtils.getText(text));

        Assert.assertEquals(BrowserUtils.getText(text), "Hello World!");
        // This Explicit wait will give TimeOutException

    }
}
