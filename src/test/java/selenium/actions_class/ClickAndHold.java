package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

public class ClickAndHold {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverHelper.getDriver();
    }

    @Test
    public void clickAndHoldPractice() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[contains(.,'Draggable 1')]"));
        WebElement draggable2 = driver.findElement(By.xpath("//span[contains(.,'Draggable 2')]"));

        WebElement dropZone = driver.findElement(By.cssSelector("#mydropzone"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(draggable1).moveToElement(dropZone).release().build().perform();
        Thread.sleep(2000);

        actions.clickAndHold(draggable2).moveToElement(dropZone).release().build().perform();
    }

    @Test
    public void clickAndHoldTask() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable = driver.findElement(By.xpath("//p[.='Drag me to my target']"));
        WebElement dropZone = driver.findElement(By.cssSelector("#droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(dropZone).release().perform();
        Thread.sleep(2000);
        WebElement droppedMsg = driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertEquals(BrowserUtils.getText(droppedMsg), "Dropped!");
    }
}
