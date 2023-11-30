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

import java.util.*;

public class HoverOver {

    WebDriver driver;

    @BeforeMethod
    public void initialize() {
        driver = DriverHelper.getDriver();
    }

    @Test
    public void hoverOverPractice() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> allUsers = driver.findElements(By.xpath("//div[@class='figure']"));
        List<WebElement> allUserNames = driver.findElements(By.xpath("//h5"));

        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1", "name: user2", "name: user3");
        Actions actions = new Actions(driver);

        for (int i = 0; i < allUsers.size(); i++) {
            Thread.sleep(1000);
            actions.moveToElement(allUsers.get(i)).perform();
            actualNames.add(BrowserUtils.getText(allUserNames.get(i)));
            System.out.println(BrowserUtils.getText(allUserNames.get(i)));
        }

        Assert.assertEquals(actualNames, expectedNames);

    }

    @Test
    public void scrollToMethod() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/hover-demo");
        WebElement area = driver.findElement(By.xpath("//div[@class='hover07 s__column']//div"));

        Actions actions = new Actions(driver);
        actions.scrollToElement(area).perform();

        //actions.scrollByAmount(700, 700).perform();
        Thread.sleep(1000);
        actions.moveToElement(area).perform();

    }

    @Test
    public void hoverOverPractice2() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='product k-listview-item']//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//h3//following-sibling::p"));

        Actions actions = new Actions(driver);

        Map<String, Double> map = new HashMap<>();

        for (int i = 0; i < images.size(); i++) {
            Thread.sleep(200);
            actions.moveToElement(images.get(i)).perform();
            map.put(BrowserUtils.getText(names.get(i)), Double.parseDouble(BrowserUtils.getText(prices.get(i)).replace("$", "")));
        }

        System.out.println(map);

    }

}
