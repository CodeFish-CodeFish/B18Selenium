package selenium.xpathrelationships;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRelations {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement nameField = driver.findElement(By.xpath("//form[@id='seleniumform']//input[@id='name']"));
        nameField.sendKeys("Kuba");

        WebElement emailField = driver.findElement(By.xpath("//form[@id='seleniumform']//input[@name='email']"));
        emailField.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement companyField = driver.findElement(By.xpath("//input[@id='company']"));
        companyField.sendKeys("CodeFish");

        WebElement webSiteField = driver.findElement(By.xpath("//label[contains(text(),'Website*')]//following-sibling::input[@id='websitename']"));
        webSiteField.sendKeys("www.google.com");

        WebElement cityField = driver.findElement(By.xpath("//input[@id='inputCity']"));
        cityField.sendKeys("City");

        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address1.sendKeys("Test st");

        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        address2.sendKeys("Test st");

        WebElement stateField = driver.findElement(By.xpath("//input[@id='inputState']"));
        stateField.sendKeys("IL");

        WebElement zipCodeField = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCodeField.sendKeys("60656");

        WebElement submitBtn = driver.findElement(By.xpath("//div[@class='text-right mt-20']//button[@type='submit']"));
        submitBtn.click();

        Thread.sleep(2000);
        WebElement successMsg = driver.findElement(By.xpath("//h1[contains(text(),'Form Demo')]"));

        if (successMsg.isDisplayed()) {
            System.out.println(successMsg.getText());
        }


    }
}
