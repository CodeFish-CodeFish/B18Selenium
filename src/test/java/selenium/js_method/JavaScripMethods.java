package selenium.js_method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;
import java.util.Set;

public class JavaScripMethods {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = DriverHelper.getDriver();

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Get Title method with JS

    @Test(priority = 1)
    public void getTitleWithJS() {

        driver.get("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String title = js.executeScript("return document.title").toString();
        System.out.println("Get title with JS -> " + title);
    }

    @Test(priority = 2)
    public void clickWithJS() {

        driver.get("https://codefish.io/");
        WebElement aboutUs = driver.findElement(By.xpath("//button[contains(.,'About us')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", aboutUs);
    }

    @Test(priority = 3)
    public void scrollIntoView() {
        driver.get("https://codefish.io/");
        WebElement faceBook = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", faceBook);
    }

    @Test(priority = 4)
    public void practiceJSMethods() throws InterruptedException {

        driver.get(ConfigReader.readProperty("url"));
        WebElement contactUS = driver.findElement(By.xpath("//a[contains(.,'Contact Us')]"));
        BrowserUtils.scrollWithJS(driver, contactUS); // Reusable method
        Thread.sleep(2000);
        BrowserUtils.clickWithJS(driver, contactUS);
        String contactUSTitle = BrowserUtils.getTitleWithJS(driver); // get title with JS
        BrowserUtils.getTitleWithJS(driver);
        Assert.assertEquals(contactUSTitle, "Contact Us | Yale University");
        System.out.println("We got the title with JS -> " + contactUSTitle);
        WebElement webEditor = driver.findElement(By.xpath("//a[.='Contact Web Editor']"));
        BrowserUtils.scrollWithJS(driver, webEditor);
        BrowserUtils.clickWithJS(driver,webEditor);
        String actualTitleOfWebEditor = BrowserUtils.getTitleWithJS(driver);
        System.out.println("Got title with JS " + actualTitleOfWebEditor);
        String expectedWebEditorTitle = "Contact Web Editor | Yale University";
        Assert.assertTrue(actualTitleOfWebEditor.contains(expectedWebEditorTitle), "Something Went Wrong");
    }

    @Test
    public void multipleTabs() throws InterruptedException {

        // We are just opening multiple window tabs at once
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://www.amazon.com/')");
        js.executeScript("window.open('https://www.ebay.com/')");
        js.executeScript("window.open('https://www.bestbuy.com/')");
        Thread.sleep(1000);

        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        BrowserUtils.switchWindowsByTitle(driver, expectedTitle);
        System.out.println(BrowserUtils.getTitleWithJS(driver) + " -- Bingo, I got the title for Amazon");


    }

    @Test
    public void testPointClass(){

        driver.navigate().to("https://codefish.io/");

        WebElement bottom = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/codefish.camp']"));

        BrowserUtils.scrollWithPoint(driver, bottom);

    }


    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(500);
        //driver.quit();
    }
}
