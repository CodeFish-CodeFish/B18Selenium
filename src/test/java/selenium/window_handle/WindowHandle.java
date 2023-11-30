package selenium.window_handle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;
import java.util.Set;



public class WindowHandle {

    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = DriverHelper.getDriver();
    }

    @Test
    public void windowHandlePractice() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHereLink = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));

        clickHereLink.click();

        String currentPageID = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Thread.sleep(2000);
        for (String id:windowHandles){
            if (!id.equals(currentPageID)){
                driver.switchTo().window(id);
            }
        }


        // This is happening in new window
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(newWindowText));
    }


    @Test
    public void practiceWindowSwitches() throws InterruptedException {

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");


        driver.findElement(By.cssSelector("#newTabBtn")).click();

        String currentPageID = driver.getWindowHandle();
        BrowserUtils.switchDriverByID(driver, currentPageID);
//        Set<String> allIDs = driver.getWindowHandles();
//        Thread.sleep(2000);
//        for (String eachID: allIDs){
//            if (!eachID.equals(currentPageID)){
//                driver.switchTo().window(eachID);
//            }
//        }

        System.out.println(BrowserUtils.getTitle(driver));
        Assert.assertEquals(BrowserUtils.getTitle(driver), "AlertsDemo - H Y R Tutorials");

        WebElement headerFromNewWindow =  driver.findElement(By.xpath("//h1[contains(.,'AlertsDemo')]"));
        System.out.println(BrowserUtils.getText(headerFromNewWindow));
        Assert.assertEquals(BrowserUtils.getText(headerFromNewWindow), "AlertsDemo");
        Thread.sleep(2000);

    }

    @Test
    public void verifyMultipleWindows() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo");


        WebElement twitter = driver.findElement(By.xpath("//a[contains(text(),'  Follow On Twitter ')]"));
        BrowserUtils.clickOnElement(twitter);
        Thread.sleep(200);

        WebElement facebook = driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook')]"));
        BrowserUtils.clickWithJS(driver, facebook);

        Thread.sleep(200);
        WebElement linkedIn = driver.findElement(By.xpath("//a[contains(text(),'Follow us On Linkedin')]"));
        BrowserUtils.clickOnElement(linkedIn);

        Set<String> windowHandles = driver.getWindowHandles();
        String wantedTitle = "LambdaTest | San Francisco CA | Facebook";
        Thread.sleep(2000);
        for (String id:windowHandles){
            driver.switchTo().window(id);
            Thread.sleep(400);
            if (BrowserUtils.getTitleWithJS(driver).contains(wantedTitle)){
                break;
            }
        }
        System.out.println(BrowserUtils.getTitleWithJS(driver));
        driver.close();



    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
