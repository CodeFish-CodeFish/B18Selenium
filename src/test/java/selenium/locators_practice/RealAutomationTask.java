package selenium.locators_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RealAutomationTask {

    public static void main(String[] args) throws InterruptedException {

        /*
        1. Click Book Appointment
        2. Login with John Doe as username, and password ThisIsNotAPassword
        3. Click radio button for Apply for Readmission, and Medicare
        4. Enter date with sendKeys();
        5. Enter something in comment section
        6. Click Book Appointment
        7. Validate what you have entered in the previous page.
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// John Doe
// ThisIsNotAPassword

        driver.findElement(By.linkText("Make Appointment")).click();
        driver.findElement(By.xpath("//input[@id='']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        checkBox.click();
        Thread.sleep(3000);


        WebElement radioBtnMedicaid = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        radioBtnMedicaid.click();

        WebElement visitDate = driver.findElement(By.xpath("//input[@name='visit_date']"));
        visitDate.sendKeys("02/05/1874");
        Thread.sleep(2000);
        WebElement textArea = driver.findElement(By.xpath("//textarea[@name='comment']"));
        textArea.sendKeys("TEST askjfsldjgh;sjkfdgsjkh jksdfgnjklhfd;kghkl sdahgkjdbckvjbckvm,ndakjfgn;a");

        WebElement bookAppointment = driver.findElement(By.xpath("//button[contains(text(),'Book')]"));
        bookAppointment.click();

        Thread.sleep(2000);

        WebElement confirmation = driver.findElement(By.tagName("h2"));
        System.out.println(confirmation.getText());

        WebElement text2 = driver.findElement(By.xpath("//p[contains(text(),'Please')]"));
        System.out.println("text2.getText() = " + text2.getText());

        WebElement answerYes = driver.findElement(By.xpath("//p[contains(text(),'Yes')]"));
        System.out.println(answerYes.isDisplayed());

        WebElement program = driver.findElement(By.xpath("//p[@id='program']"));
        System.out.println(program.getText());

        WebElement visitDate2 = driver.findElement(By.xpath("//p[@id='visit_date']"));

        if (visitDate2.getText().contains("02/05/1874")){
            System.out.println(visitDate2.getText().trim());
        }
        WebElement comment = driver.findElement(By.xpath("//p[@id='comment']"));
        if (comment.isDisplayed()){
            System.out.println(comment.getText());
        }

        WebElement homePage = driver.findElement(By.xpath("//a[@href='https://katalon-demo-cura.herokuapp.com/']"));
       if (homePage.isDisplayed()){
           homePage.click();
       }

       driver.quit();

    }
}
