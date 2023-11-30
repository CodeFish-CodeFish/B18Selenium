package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DriverHelper;

public class MoveByOffSet {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void moveByOffSetPractice() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions = new Actions(driver);

        actions.clickAndHold(slider).moveByOffset(30, 0).perform();
        Thread.sleep(2000);
        actions.clickAndHold(slider).moveByOffset(-30, 0).perform();


    }

    @Test
    public void taskOnMoveByOffSet(){

        driver.get("https://www.lambdatest.com/selenium-playground/drag-drop-range-sliders-demo");
        WebElement slider1 = driver.findElement(By.xpath("//input[@value='5']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider1).moveByOffset(250, 0).perform();


    }


}
