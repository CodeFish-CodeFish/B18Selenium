package selenium.practice_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Register {

    WebDriver driver;

    @BeforeMethod
    public  void setUp(){
        driver = new ChromeDriver();

    }

    @Test
    public void validateRegister() throws InterruptedException {

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstName = driver.findElement(By.cssSelector("input[name='firstname']"));
        firstName.sendKeys("Kuba");

        WebElement lastName = driver.findElement(By.cssSelector("#input-lastname"));
        lastName.sendKeys("Abdy");

        WebElement emailField = driver.findElement(By.cssSelector("#input-email"));
        emailField.sendKeys("test@test.io");

        WebElement tel = driver.findElement(By.cssSelector("#input-telephone"));
        tel.sendKeys("3123123213");

        WebElement pass1 = driver.findElement(By.cssSelector("#input-password"));
        pass1.sendKeys("123456");

        WebElement pass2 = driver.findElement(By.cssSelector("#input-confirm"));
        pass2.sendKeys("123456");

        List<WebElement> radios = driver.findElements(By.cssSelector(".radio-inline"));
        Thread.sleep(2000);
        for (int i = 0; i < radios.size(); i++) {

            if (BrowserUtils.getText(radios.get(i)).equals("Yes")){
                radios.get(i).click();
            }

        }

        driver.findElement(By.cssSelector("input[name='agree']")).click();

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(2000);
        WebElement successMsg = driver.findElement(By.cssSelector("div[id='content']>h1"));

        System.out.println(BrowserUtils.getText(successMsg));
        String actualMsg = BrowserUtils.getText(successMsg);
        String expectedMsg = "Your Account Has Been Created!";
        Assert.assertEquals(actualMsg, expectedMsg);


    }

    @Test()
    public void test(){
        driver.get("https://www.google.com/");
    }


}
