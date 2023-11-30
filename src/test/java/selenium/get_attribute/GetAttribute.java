package selenium.get_attribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class GetAttribute {



    @Test
    public void validateAttribute() {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://codefish.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement element = driver.findElement(By.xpath("//div[@class='program-menu']"));
        String id = element.getAttribute("id");
        System.out.println(id);

        WebElement kickStartIT = driver.findElement(By.xpath("//p[@class='sub-title']"));
        String className = kickStartIT.getAttribute("class");
        System.out.println(className);

        List<WebElement> elements = driver.findElements(By.cssSelector("p[class='number']"));
        for (int i = 0; i < elements.size(); i++) {

            Assert.assertEquals(elements.get(i).getAttribute("class"), "number");

        }
    }

    @Test
    public void TC_02(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("div[role='checkbox']"));
        for (WebElement element: allCheckBoxes){

            if (element.getAttribute("aria-checked").equals("false")){
                element.click();
            }

        }

    }


}
