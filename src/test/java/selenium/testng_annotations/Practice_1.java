package selenium.testng_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Practice_1 {

    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void TC_01() throws InterruptedException {


        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("demo");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='btn-close']")).click();

        driver.findElement(By.cssSelector("a[href='#collapse-1']")).click();

        driver.findElement(By.xpath("//a[contains(.,'Products')]")).click();
        Thread.sleep(2000);
        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (int i = 1; i < allCheckBoxes.size(); i++) {

            Thread.sleep(200);
            //allCheckBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
            allCheckBoxes.get(i).click();
            allCheckBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }

    }

    @Test
    public void check_ascendingOrder() throws InterruptedException {
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("demo");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[class='btn-close']")).click();

        driver.findElement(By.cssSelector("a[href='#collapse-1']")).click();

        driver.findElement(By.xpath("//a[contains(.,'Products')]")).click();
        Thread.sleep(2000);

        List<WebElement> allProducts = driver.findElements(By.xpath("//tr//td[3]"));
        List<String> actualProducts = new ArrayList<>(); //
        List<String> expectedProducts = new ArrayList<>();

        for (int i = 1; i < allProducts.size(); i++) {

            actualProducts.add(BrowserUtils.getText(allProducts.get(i)));

            expectedProducts.add(BrowserUtils.getText(allProducts.get(i)));
            Collections.sort(expectedProducts);
            Assert.assertEquals(actualProducts, expectedProducts);
        }

        System.out.println(actualProducts + " unsorted from the webpage");
        System.out.println(expectedProducts + " sorted to compare with actualProducts");





    }


    @AfterMethod
    public void stop() {
       // driver.quit();
    }
}
