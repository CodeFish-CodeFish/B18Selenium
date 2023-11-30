package selenium.pop_ups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class AlertInterface {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void acceptAndGetText() throws InterruptedException {

        driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Thread.sleep(1000);
        Assert.assertEquals(alertText, "I am a JS Alert");
        alert.accept();
        WebElement resultMsg = driver.findElement(By.cssSelector("#result"));
        Assert.assertTrue(BrowserUtils.getText(resultMsg).equals("You successfully clicked an alert"));


    }

    @Test
    public void dismissAndAccept() throws InterruptedException {

        WebElement clickJSConfirm = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        clickJSConfirm.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        Assert.assertEquals(alertText, "I am a JS Confirm");
        alert.dismiss();
        Thread.sleep(2000);
        WebElement resultMsg = driver.findElement(By.cssSelector("p[id='result']"));

        Assert.assertEquals(BrowserUtils.getText(resultMsg), "You clicked: Cancel");

        clickJSConfirm.click();

        alert.accept();

        Assert.assertEquals(BrowserUtils.getText(resultMsg), "You clicked: Ok");

    }

    @Test
    public void sendKeysIntoAlert() throws InterruptedException {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("CodeFish Rock Stars");
        Thread.sleep(2000);
        alert.accept();

        WebElement resultMsg = driver.findElement(By.cssSelector("p[id='result']"));
        Assert.assertEquals(BrowserUtils.getText(resultMsg),"You entered: CodeFish Rock Stars");


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
