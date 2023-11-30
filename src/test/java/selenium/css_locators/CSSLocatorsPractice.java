package selenium.css_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CSSLocatorsPractice {


    @Test()
    public void TC_01_CheckCSS() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground/ajax-form-submit-demo");

        driver.findElement(By.cssSelector("#title")).sendKeys("Test message");
        driver.findElement(By.cssSelector("textarea[name='description']")).sendKeys("test test test");

        driver.findElement(By.cssSelector("div>input[id='btn-submit']")).click();


    }

    @Test()
    public void validatePHPTRavel() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://phptravels.com/demo");

        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("KObe");
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Abdy");
        driver.findElement(By.cssSelector("input[name='business_name']")).sendKeys("my business");
        driver.findElement(By.cssSelector("input[class='email form-control']")).sendKeys("test@test.com");

        WebElement num1 = driver.findElement(By.cssSelector("#numb1"));
        WebElement num2 = driver.findElement(By.cssSelector("#numb2"));

        int answer = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());

        WebElement answerField = driver.findElement(By.cssSelector("input[id='number']"));
        answerField.sendKeys(String.valueOf(answer));

        driver.findElement(By.cssSelector("button[id='demo']")).click();
        Thread.sleep(3000);
        WebElement thankYou = driver.findElement(By.xpath("//h2[contains(.,' Thank you!')]"));
        Assert.assertEquals(thankYou.getText().trim(), "Thank you!");
        Assert.assertTrue(thankYou.isDisplayed());


    }
}
