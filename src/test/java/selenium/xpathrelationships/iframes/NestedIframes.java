package selenium.xpathrelationships.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.DriverHelper;

public class NestedIframes {

    WebDriver driver;
    @BeforeMethod
    public void setDriver90(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void nestedIframesExample(){

        SoftAssert softAssert = new SoftAssert();

        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftTxt = driver.findElement(By.xpath("//body[contains(.,'LEFT')]"));
        softAssert.assertEquals(BrowserUtils.getText(leftTxt), "LEFT");

        driver.switchTo().parentFrame();
        //driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        WebElement middleTxt = driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]"));
        System.out.println(BrowserUtils.getText(middleTxt));

//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame(); // this will move only 1 step back
        driver.switchTo().defaultContent(); // will take you to your main html structure

        driver.switchTo().frame("frame-bottom");

        WebElement bottomTxt = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        System.out.println(BrowserUtils.getText(bottomTxt));


    }

    @Test
    public void taskIframe() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='./contant']"));
        driver.switchTo().frame(iframe);

        WebElement inputField = driver.findElement(By.xpath("//div[@class='rsw-ce']"));
        inputField.clear();
        inputField.sendKeys("Kobe Test");

        BrowserUtils.switchToParentFrameOrDefault(driver, "default");
      //  driver.switchTo().defaultContent();
        BrowserUtils.switchToIframe(driver, "myiFrame");
      //  driver.switchTo().frame("myiFrame");

        WebElement nextBtn  = driver.findElement(By.xpath("//div[@class='pagination-nav__label']"));
        BrowserUtils.scrollWithJS(driver, nextBtn);
        Thread.sleep(2000);
        nextBtn.click();

        WebElement nextPageHeader = driver.findElement(By.xpath("//h1[contains(.,'Selenium Automation Testing Using LambdaTest')]"));

        System.out.println("BrowserUtils.getText(nextPageHeader) = " + BrowserUtils.getText(nextPageHeader));


    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
