package selenium.xpathrelationships.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.DriverHelper;

public class IFrames {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverHelper.getDriver();
    }


    @Test
    public void iframeIntro() {

        driver.get("https://the-internet.herokuapp.com/iframe");

       // WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_if']"));

        driver.switchTo().frame("mce_0_ifr"); // if there are no iframe or id is not correct, you will get NoSuchFrameException

        WebElement textAea = driver.findElement(By.xpath("//p[contains(.,'Your content goes here.')]"));

        textAea.clear();

        textAea.sendKeys("test test");

        driver.switchTo().defaultContent(); // brings the driver to default content meaning to main page

        WebElement outSideIframe = driver.findElement(By.xpath("//h3[contains(.,'An iFrame containing the TinyMCE WYSIWYG Editor')]"));

        System.out.println(BrowserUtils.getText(outSideIframe));
    }

    @Test
    public void example_2(){

        driver.get("https://skpatro.github.io/demo/iframes/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='Frame1']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[contains(.,'Category1')]")).click();
        String title = "SeleniumTesting Archives - qavalidation";
        BrowserUtils.switchWindowsByTitle(driver, title);

        WebElement header = driver.findElement(By.xpath("//h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Category Archives: SeleniumTesting";
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualHeader, expectedHeader);
        softAssert.assertAll();

        BrowserUtils.switchWindowsByTitle(driver, "iframes");

        driver.switchTo().frame("Frame2");

        driver.findElement(By.xpath("//a[contains(text(),'Category3')]")).click();
        BrowserUtils.switchWindowsByTitle(driver, "SoftwareTesting Archives - qavalidation");

        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(BrowserUtils.getText(header2));


    }
}
