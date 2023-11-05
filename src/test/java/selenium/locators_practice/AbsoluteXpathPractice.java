package selenium.locators_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AbsoluteXpathPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("A/B Testing")).click();

        WebElement paragraph = driver.findElement(By.xpath("/html/body/div[2]/div/div/p")); // This is Absolute Xpath
        String text = paragraph.getText();
        System.out.println(text);

        WebElement link = driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")); // This is Relative Xpath Expression
        link.click();

    }
}
