package selenium.select_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectPractice_01 {

    @Test
    public void validateSelect() {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("Dropdown")).click();

        WebElement dropdown = driver.findElement(By.cssSelector("select[id='dropdown']"));

        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();

        for (WebElement el : allOptions) {
            System.out.println(el.getText());
        }

        // select.selectByVisibleText("Option 2");

        //select.selectByValue("2");

        //select.selectByIndex(1);

        WebElement element = select.getFirstSelectedOption();
        Assert.assertEquals(element.getText().trim(), "Please select an option");


    }

    @Test()
    public void practiceSelect() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/table-pagination-demo");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement dropdown = driver.findElement(By.cssSelector("select[name='state']"));
        Select select = new Select(dropdown);
        select.selectByValue("5000");

        List<WebElement> allFirstNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allLastNames = driver.findElements(By.xpath("//tr//td[3]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[4]"));

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < allFirstNames.size(); i++) {


            String str = "";

            str += allFirstNames.get(i).getText();
            str += "-" + allLastNames.get(i).getText();

            map.put(str, allEmails.get(i).getText());

        }
        System.out.println(map);


    }

    @Test()
    public void bookFlight() {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("input[value='oneway']")).click();

        WebElement passengers = driver.findElement(By.cssSelector("select[name='passCount']"));

        Select pass = new Select(passengers);
        pass.selectByVisibleText("4");

        WebElement portCity = driver.findElement(By.cssSelector("select[name='fromPort']"));

        Select city = new Select(portCity);
        String firstOption = city.getFirstSelectedOption().getText();
        Assert.assertEquals(firstOption, "Acapulco");

        WebElement toPort = driver.findElement(By.cssSelector("select[name='toPort']"));
        Select port = new Select(toPort);

        List<WebElement> allOptions = port.getOptions();

        for (int i = 0; i < allOptions.size(); i++) {

            if (allOptions.get(i).getText().equals("Sydney")) {
                port.selectByVisibleText("Sydney");
            }

        }

        WebElement toMonth = driver.findElement(By.cssSelector("select[name='toMonth']"));

        Select month = new Select(toMonth);
        month.selectByIndex(7);

        WebElement firstClass = driver.findElement(By.cssSelector("input[value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.cssSelector("select[name='airline']"));

        Select airLinesOptions = new Select(airlines);
        WebElement firstSelectedOption = airLinesOptions.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());


        // We will finish this on Saturday morning


    }

    @Test
    public void reusableMethodForSelect() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("input[value='oneway']")).click();

        WebElement passCount = driver.findElement(By.cssSelector("select[name='passCount']"));
        BrowserUtils.selectBy(passCount, "4", "visibleText");

        WebElement firstOptionCity = driver.findElement(By.cssSelector("select[name='fromPort']"));
        Select select = new Select(firstOptionCity);
        WebElement firstCity = select.getFirstSelectedOption();
        String actualCity = firstCity.getText();
        String expectedCity = "Acapulco";
        Assert.assertEquals(actualCity, expectedCity);
        WebElement month = driver.findElement(By.cssSelector("select[name='fromMonth']"));
        BrowserUtils.selectBy(month, "8", "index");

        WebElement allCities = driver.findElement(By.cssSelector("select[name='toPort']"));

        List<String> expectedCities = Arrays.asList("Acapulco", "Frankfurt", "London", "New York", "Paris",
                "Portland", "San Francisco", "Seattle", "Sydney", "Zurich");

        List<WebElement> actualCities = BrowserUtils.getAllOptionsSelect(allCities);

        for (int i = 0; i < expectedCities.size(); i++) {

            Assert.assertEquals(actualCities.get(i).getText().trim(), expectedCities.get(i).trim());

        }

        WebElement firstClass = driver.findElement(By.cssSelector("input[value='First']"));
        firstClass.click();

        WebElement airlines = driver.findElement(By.cssSelector("select[name='airline']"));

        List<WebElement> allOptionsSelect = BrowserUtils.getAllOptionsSelect(airlines);
        for (int i = 0; i < allOptionsSelect.size(); i++) {

            if (allOptionsSelect.get(i).getText().trim().equals("Unified Airlines")) {
                BrowserUtils.selectBy(airlines, "Unified Airlines", "visibleText");
            }

        }

        driver.findElement(By.cssSelector("input[name='findFlights']")).click();
        Thread.sleep(2000);
        List<WebElement> text = driver.findElements(By.xpath("//font[contains(.,'After flight finder - No Seats Avaialble')]"));

        Thread.sleep(2000);
        for (int i = 1; i < 2; i++) {

           Assert.assertEquals(BrowserUtils.getText(text.get(i)), "After flight finder - No Seats Avaialble");

        }


    }
}
