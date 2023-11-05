package selenium.locators_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RelativeXPath {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://codefish.io/contacts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.sendKeys("Kuba Test");

        WebElement phoneField = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneField.sendKeys("+31223232323232323");

        WebElement emailField = driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys("test");

        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='body']"));
        textArea.sendKeys("test test test");

        WebElement submitBtn = driver.findElement(By.xpath("//span[@class='submit-p']"));
        submitBtn.click();

        WebElement errorMsgPhone = driver.findElement(By.xpath("//p[contains(text(),'Invalid phone number')]"));

        if (errorMsgPhone.isDisplayed()){
            System.out.println(errorMsgPhone.getText());
        }else {
            System.out.println("Error message not displayed");
        }

        WebElement errorMsgEmail = driver.findElement(By.xpath("//p[contains(text(),'Invalid email')]"));

        if (errorMsgEmail.isDisplayed()){
            System.out.println(errorMsgEmail.getText());
        }else {
            System.out.println("failed");
        }

        WebElement errorMsgRequired = driver.findElement(By.xpath("//p[contains(text(),'Required')]"));

        if (errorMsgRequired.isDisplayed()){
            System.out.println(errorMsgRequired.getText());
        }else {
            System.out.println("failed");
        }




    }
}
