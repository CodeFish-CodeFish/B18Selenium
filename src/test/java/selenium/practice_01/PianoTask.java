package selenium.practice_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PianoTask {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
       driver = new ChromeDriver();
       driver.get("https://www.musicca.com/piano");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void validatePiano() throws InterruptedException {

        List<WebElement> keys = driver.findElements(By.xpath("//span[@data-note"));

        List<String> music = Arrays.asList("2c", "2c","2g","2g","3a", "3a", "2g", "2f","2f", "2e", "2e","2d", "2d","2c");
        List<String> music2 = Arrays.asList("2gis", "2e","2gis","2e","2gis","2e","2gis", "2e","2fis","2e","2fis","2e","2fis","2e");

        Map<String, WebElement> keyBoard = new HashMap<>();

        for (WebElement key: keys){

            keyBoard.put(key.getAttribute("data-note"), key);
        }

        for (String note: music2){

            WebElement key = keyBoard.get(note);
            key.click();
            Thread.sleep(300);
        }


    }

    @AfterMethod
    public void tearDown(ITestResult result){

        if (!result.isSuccess()){
            BrowserUtils.getScreenshot(driver);
        }

    }
}
