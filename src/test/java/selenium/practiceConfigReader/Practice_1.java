package selenium.practiceConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.DriverHelper;

public class Practice_1 {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void test(){

        driver.get(ConfigReader.readProperty("urlForWeb"));
        WebElement userName = driver.findElement(By.cssSelector("#input-username"));
        WebElement passWord = driver.findElement(By.cssSelector("#input-password"));

        userName.sendKeys(ConfigReader.readProperty("userName"));
        passWord.sendKeys(ConfigReader.readProperty("passwordForMe"));
    }
}
