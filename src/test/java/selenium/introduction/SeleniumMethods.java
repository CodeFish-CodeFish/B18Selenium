package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumMethods {


    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://codefish.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        String expectedTitle = "CodeFish";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        String actualURL = driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);

        String expectedURL = "https://codefish.io/";
        System.out.println("expectedURL = " + expectedURL);

        if (actualURL.equals(expectedURL)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }

    }

}
