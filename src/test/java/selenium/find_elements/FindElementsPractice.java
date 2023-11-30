package selenium.find_elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allLinks = driver.findElements(By.xpath("//li"));

        for (int i = 0; i < allLinks.size(); i++) {

            System.out.println(allLinks.get(i).getText());

        }
        int count = 0;
        for (int i = 0; i < allLinks.size(); i++) {

            if (allLinks.get(i).getText().length() < 10) {
                System.out.println(allLinks.get(i).getText());
                count++;
            }

        }
        System.out.println(count);


    }
}
