package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.godaddy.com/";

        if (actualURL.equals(expectedURL)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }


    }
}
