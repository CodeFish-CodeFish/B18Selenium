package selenium.locators_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorExercise {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("Horizontal Slider")).click();

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println("header = " + header.getText());

        WebElement paragraph = driver.findElement(By.tagName("h4"));
        System.out.println("paragraph.getText() = " + paragraph.getText());

        WebElement footer = driver.findElement(By.linkText("Elemental Selenium"));
        footer.click();


        if (driver.getCurrentUrl().equals("https://elementalselenium.com/")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }


    }
}
