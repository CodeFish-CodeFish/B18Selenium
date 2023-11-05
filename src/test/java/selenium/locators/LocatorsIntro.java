package selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsIntro {

    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement searchBar = driver.findElement(By.id("APjFqb"));

        searchBar.sendKeys("iPhone 15 Pro Max", Keys.ENTER);



    }
}
