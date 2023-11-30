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

public class DragAndDrop {

    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void dragAndDropShowCase() throws InterruptedException {
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        WebElement draggable1 = driver.findElement(By.xpath("//span[contains(.,'Draggable 1')]"));

        WebElement draggable2 = driver.findElement(By.xpath("//span[contains(.,'Draggable 2')]"));

        WebElement dropZone = driver.findElement(By.cssSelector("#mydropzone"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable1, dropZone).build().perform();
        actions.dragAndDrop(draggable2, dropZone).build().perform();

        Thread.sleep(2000);

        WebElement dragMeToMyTarget = driver.findElement(By.xpath("//p[contains(.,'Drag me to my target')]"));

        WebElement dropPlace = driver.findElement(By.cssSelector("#droppable"));

        actions.dragAndDrop(dragMeToMyTarget, dropPlace).build().perform();

        String backgroundColor = dropPlace.getCssValue("background-color");
        System.out.println(backgroundColor);

        WebElement droppedText = driver.findElement(By.xpath("//p[contains(.,'Dropped!')]"));

        System.out.println(BrowserUtils.getText(droppedText));


    }

    @Test
    public void task1(){

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));

        WebElement dropArea = driver.findElement(By.xpath("//div[@class='test2']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, dropArea).perform();
        dropArea = driver.findElement(By.xpath("//div[@class='test2']")); // Re - initialized our variable
        String str = dropArea.getCssValue("background-color");
        System.out.println(str);
        Assert.assertEquals(str, "rgba(238, 111, 11, 1)");
    }

    @Test
    public void task2(){

        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropArea = driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable, dropArea).build().perform();

        System.out.println(BrowserUtils.getText(dropArea));
        String actualColor = dropArea.getCssValue("background-color");
        System.out.println(actualColor);
        Assert.assertEquals(actualColor, "rgba(70, 130, 180, 1)");

    }

    @Test
    public void task3(){

        driver.get("https://demoqa.com/droppable");

        WebElement acceptTab = driver.findElement(By.xpath("//a[contains(.,'Accept')]"));
//        Actions actions = new Actions(driver);
//        actions.click(acceptTab).perform();

        BrowserUtils.clickWithActions(driver, acceptTab);
        WebElement acceptable = driver.findElement(By.cssSelector("#acceptable"));

        WebElement notAcceptable = driver.findElement(By.cssSelector("#notAcceptable"));

        WebElement dropArea = driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-accept']//div[@id='droppable']"));

//        actions.dragAndDrop(acceptable, dropArea).perform();
//        actions.dragAndDrop(notAcceptable, dropArea).perform();
        BrowserUtils.dragAndDrop(driver,acceptable, dropArea);
        BrowserUtils.dragAndDrop(driver,notAcceptable, dropArea);

        System.out.println(BrowserUtils.getText(dropArea));
        String actualColorRGBA = dropArea.getCssValue("background-color");
        System.out.println(actualColorRGBA);

        Assert.assertEquals(actualColorRGBA, "rgba(70, 130, 180, 1)");





    }
}
