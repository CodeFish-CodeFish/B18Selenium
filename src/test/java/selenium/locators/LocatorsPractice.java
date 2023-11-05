package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/codefish/Desktop/HTMLClass/forms2.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /*
        Locators are found by ID, Name, ClassName, TagName, LinkText, and PartialLinkText


         */

        WebElement firstName = driver.findElement(By.id("fname"));
        firstName.sendKeys("Kuba");
        Thread.sleep(2000);
        WebElement lastName = driver.findElement(By.name("lname"));
        lastName.sendKeys("Abdy");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("test");
        Thread.sleep(2000);
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("test@test.com");
        Thread.sleep(2000);
        WebElement phoneNumber = driver.findElement(By.id("phone"));
        phoneNumber.sendKeys("312323232323");
        Thread.sleep(2000);
        WebElement className = driver.findElement(By.className("my-class"));
        System.out.println("className.getText() = " + className.getText());
        Thread.sleep(2000);
        WebElement tagName = driver.findElement(By.tagName("h3"));
        System.out.println("tagName.getText() = " + tagName.getText());

//        Thread.sleep(2000);
//        WebElement linkText = driver.findElement(By.linkText("Click Here"));
//        linkText.click();
//        Thread.sleep(1000);
//        WebElement partialLinkText = driver.findElement(By.partialLinkText("Me"));
//        partialLinkText.click();

        WebElement radioBtn = driver.findElement(By.id("Dr."));

        if (!radioBtn.isSelected()){
            Thread.sleep(2000);
            radioBtn.click();
        }else {
            System.out.println("Radio button is not present");
        }

        WebElement checkBox = driver.findElement(By.name("subscribe"));

        if (checkBox.isDisplayed()){
            checkBox.click();
        }else {
            System.out.println("checkBox is missing");
        }

        WebElement textArea = driver.findElement(By.tagName("textarea"));
        textArea.sendKeys("ksjdfbjkabdsgjkfbsdljkghsd,hg,djsfg,hjdasfg" +
                "skdfjdksjhfkjadhgflfkhsdlkghadsljgfhlkdsjhlfkjadshf" +
                "fdksjfahkjsdfkdjsahgkjhasdkjghkajhgfklhlgkjhldaksjhgkds" +
                "dskgnajkfdhgjdfhgkjdhfakgjhdfkajghkjahgkjdfhglkjadhsg" +
                "dsakjgbakdjgbkjfhagk;jhadskjghf;jhr;iwuehr;oijBFJHBSD.KF");



   //Break time

    }
}
