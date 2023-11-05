package selenium.introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumBasics {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/codefish/Desktop/chromedriver");
        // if windows add .exe at the end of chromedriver
        // if Mac just chromedriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.navigate().to("https://www.youtube.com/");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        driver.navigate().forward();
        System.out.println("driver.getPageSource() = " + driver.getPageSource());
        driver.close();



    }
}
