package selenium.sendKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class PracticeSendKeys {

    @Test
    public void slideIt(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[contains(.,'Drag & Drop Sliders')]")).click();
        WebElement slider = driver.findElement(By.xpath("//div[@id='slider1']//input[@type='range']"));
        WebElement output = driver.findElement(By.xpath("//div[@class='sp__range']"));

        while (!BrowserUtils.getText(output).equals("85")){
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    @Test
    public void slideItAll(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//a[contains(.,'Drag & Drop Sliders')]")).click();

        List<WebElement> allSliders = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutPut = driver.findElements(By.cssSelector("output"));

        for (int i = 0; i < allOutPut.size(); i++) {

            while (!BrowserUtils.getText(allOutPut.get(i)).equals("85")){
                allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
            }

        }



    }


}
