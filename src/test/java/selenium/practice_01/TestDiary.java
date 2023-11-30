package selenium.practice_01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.sql.DriverManager;
import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class TestDiary {

    /*
    Navigate to webpage
Choose selenium with if condition -> if Selenium is displayed and it is not selected, then choose Selenium,
Uncheck Rest API
Check Java and Save
Click Test Diary and print out URL and Header and validate them both
Click Test Diary Selenium print out URL and Header validate them both
Choose Yellow Shirt and Red Skirt from the dropdown, you must use BrowserUtils
Fill out  name, email, subject and message body click send
Validate with if condition if success message is displayed and it went smoothly


     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
        // https://www.techlistic.com/p/selenium-practice-form.html
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @Test
    public void validateTestDiary() throws InterruptedException {
//http://www.testdiary.com/training/selenium/selenium-test-pag
        WebElement seleniumBox = driver.findElement(By.cssSelector("#seleniumbox"));

        if (seleniumBox.isDisplayed() && !seleniumBox.isSelected()) {
            seleniumBox.click();
        }

        WebElement restAPI = driver.findElement(By.cssSelector("#restapibox"));

        if (restAPI.isDisplayed() && restAPI.isSelected()) {
            restAPI.click();
        }


        WebElement javaBox = driver.findElement(By.cssSelector("#java1"));
        javaBox.click();

        driver.findElement(By.cssSelector("#demo")).click();

        WebElement testDiaryLink = driver.findElement(By.linkText("Test Diary"));
        testDiaryLink.click();

        Thread.sleep(3000);
        WebElement headerOfTestDiary = driver.findElement(By.xpath("//h1[contains(.,'Test Diary')]"));
        String actualHeader = BrowserUtils.getText(headerOfTestDiary);
        System.out.println(actualHeader);
        String expectedHeader = "Test Diary";

        assertEquals(actualHeader, expectedHeader);

        String actualURL = driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);
        String expectedURL = "http://www.testdiary.com/";

        assertEquals(actualURL, expectedURL);

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Test Diary - A software testers guide";
        assertEquals(actualTitle, expectedTitle);
        driver.navigate().back();

        WebElement testDiary2 = driver.findElement(By.linkText("Test Diary Selenium Learning"));

        testDiary2.click();
        Thread.sleep(2000);

        WebElement header2 = driver.findElement(By.xpath("//h1[contains(.,'Selenium')]"));
        String actualHeader2 = BrowserUtils.getText(header2);
        String expectedHeader2 = "Selenium";
        System.out.println(actualHeader2);
        assertEquals(actualHeader2, expectedHeader2);

        String actualURL2 =  driver.getCurrentUrl();
        System.out.println(actualURL2);
        String expectedURL2 = "http://www.testdiary.com/training/selenium/";
        assertEquals(actualURL2, expectedURL2);

        Assert.assertEquals(BrowserUtils.getTitle(driver), "Selenium - Test Diary");
        driver.navigate().back();

        Thread.sleep(2000);
        WebElement dropDownShirts = driver.findElement(By.cssSelector("select[id='Shirts']"));
        BrowserUtils.selectBy(dropDownShirts, "yellow", "value");

        WebElement skirts = driver.findElement(By.cssSelector("#Skirts"));

        BrowserUtils.selectBy(skirts, "Red Skirt", "visibleText");

        WebElement yourName = driver.findElement(By.cssSelector("input[name='your-name']"));
        yourName.sendKeys("Kuba Abdy");

        WebElement yourEmail = driver.findElement(By.cssSelector("input[name='your-email']"));
        yourEmail.sendKeys("test@test.io");

        WebElement subjectLine = driver.findElement(By.cssSelector("input[name='your-subject']"));
        subjectLine.sendKeys("subject line goes here");

        WebElement textArea =driver.findElement(By.cssSelector("textarea[name='your-message']"));
        textArea.sendKeys("dear sir/madam please accept my resume and get me an offer");

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement successMsg = driver.findElement(By.xpath("//form//div[contains(.,'Your message was sent successfully. Thanks.')]"));

        if (successMsg.isDisplayed()){
            System.out.println("Message went through");
            System.out.println(BrowserUtils.getText(successMsg));
        }else {
            System.out.println("Message did not go through");
        }



    }

    @Test
    public void demoAutomation() throws InterruptedException {

        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Kobe");
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Abdy");
        driver.findElement(By.cssSelector("#sex-0")).click();
        driver.findElement(By.cssSelector("#exp-6")).click();

        driver.findElement(By.cssSelector("#datepicker")).sendKeys("11/12/2023");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#profession-1")).click();

        driver.findElement(By.cssSelector("#tool-2")).click();

        WebElement continents = driver.findElement(By.cssSelector("#continents"));

        BrowserUtils.selectBy(continents, "Antartica", "visibleText");

        WebElement seleniumCommands = driver.findElement(By.cssSelector("#selenium_commands"));

        BrowserUtils.selectBy(seleniumCommands, "WebElement Commands", "visibleText");
        driver.findElement(By.cssSelector("#photo")).sendKeys(
                "/Users/codefish/Desktop/download.png");

        driver.findElement(By.cssSelector("#submit")).click();


    }

}
