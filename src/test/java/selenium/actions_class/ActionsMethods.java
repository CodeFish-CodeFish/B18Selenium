package selenium.actions_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

public class ActionsMethods {

    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void contextClick() {

        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Context Menu")).click();

        WebElement rightClickArea = driver.findElement(By.cssSelector("#hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(rightClickArea).perform();
        BrowserUtils.acceptAlert(driver);

    }

    @Test
    public void doubleClickAndRightClick() throws InterruptedException {


        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickMe = driver.findElement(By.xpath("//span[contains(.,'right click me')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMe).build().perform();

        WebElement quit = driver.findElement(By.xpath("//span[.='Quit']"));

        actions.click(quit).build().perform();
        BrowserUtils.acceptAlert(driver);

        Thread.sleep(2000);

        WebElement doubleClickMe = driver.findElement(By.xpath("//button[contains(.,'Double-Click Me To See Alert')]"));

        actions.doubleClick(doubleClickMe).perform();
        BrowserUtils.acceptAlert(driver);

    }

    @Test
    public void taskForDoubleAndRightClicks() throws InterruptedException {

        driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");

        WebElement doubleClickMe = driver.findElement(By.xpath("//button[.='Double-Click me to see Alert message']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMe).perform();
        BrowserUtils.acceptAlert(driver);
        Thread.sleep(2000);

        driver.get("https://www.lambdatest.com/selenium-playground/context-menu");
        WebElement rightClickHere = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(rightClickHere).perform();
        BrowserUtils.acceptAlert(driver);




    }


}
