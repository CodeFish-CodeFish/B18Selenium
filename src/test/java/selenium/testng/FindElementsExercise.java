package selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindElementsExercise {

    @Test() // this is an annotation
    public void TC_01() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://codefish.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='gradient-block']//p"));

        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getText());

        }

    }

    @Test()
    public void TC_02(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allNames =driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < allNames.size(); i++) {

            map.put(allNames.get(i).getText(), allEmails.get(i).getText());

        }
        System.out.println(map);

    }
}
