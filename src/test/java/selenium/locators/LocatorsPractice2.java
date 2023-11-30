package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsPractice2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://codefish.io/contacts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement name = driver.findElement(By.name("name"));
        name.sendKeys("Kuba");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("3123232323");

        WebElement textarea = driver.findElement(By.className("textarea"));
        textarea.sendKeys("test");
        Thread.sleep(2000);

        WebElement programs = driver.findElement(By.className("program-menu"));
        programs.click();

    }


}
