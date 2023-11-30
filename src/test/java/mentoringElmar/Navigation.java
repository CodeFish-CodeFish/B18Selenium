package mentoringElmar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class Navigation {

    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void testNavigation() {
        driver.get("https://www.newegg.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> leftNavigation = driver.findElements(By.
                xpath("//div[@class='menu-body']//li[@class='menu-level-3 menu at-right']"));

        navigateTo(leftNavigation, "electronics");

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.newegg.com/Electronics/Store/ID-10");
    }

    @Test
    public void testHeader() {
        driver.get("https://www.newegg.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        List<WebElement> headerElements = driver.findElements(By.
                xpath("//span[@class='font-s']"));

        navigateTo(headerElements, "PC Builder");

        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.newegg.com/tools/custom-pc-builder?cm_sp=Head_Navigation-_-Under_Search_Bar-_-PC+Builder&icid=671801");
    }

    @Test
    public void testNavigateWithSwitch() {
        driver.get("https://www.newegg.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement pageBlackFridayAds = driver.findElement(By.xpath("//span[.='Black Friday Ads']"));
        WebElement pageBlackFridayDeals = driver.findElement(By.xpath("//span[.='Black Friday Deals']"));
        WebElement pageTodaysBestDeal = driver.findElement(By.xpath("//span[contains(text(), 'Best Deals')]"));
        // ...
        switch ("Black Friday Deals".toLowerCase()) {
            case "black friday ads": pageBlackFridayAds.click(); break;
            case "black friday deals": pageBlackFridayDeals.click(); break;
            case "today's best deals": pageTodaysBestDeal.click(); break;
            // ...
            default:
                Assert.fail("Page not found");
        }
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://www.newegg.com/Black-Friday-Deals/EventSaleStore/ID-1133?cm_sp=Head_Navigation-_-Under_Search_Bar-_-Black+Friday+Deals&icid=765856");
    }

    private static void navigateTo(List<WebElement> elements, String endPoint) {
        for (WebElement el : elements) {
            if (BrowserUtils.getText(el).equalsIgnoreCase(endPoint)) {
                el.click();
                return;
            }
        }
        Assert.fail("Page \"" + endPoint +"\" not found!!!");
    }

}
