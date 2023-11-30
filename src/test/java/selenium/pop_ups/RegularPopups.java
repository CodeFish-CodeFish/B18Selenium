package selenium.pop_ups;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;
import java.time.Duration;

public class RegularPopups {
    WebDriver driver;
    @BeforeMethod
    public void startUp(){
        driver = new ChromeDriver();
        driver.get("https://sweetalert.js.org/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void TC_01() throws InterruptedException {

        driver.findElement(By.xpath("//h5[contains(text(),'Normal alert')]//following-sibling::button")).click(); // first one
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Oops, something went wrong!");
        alert.accept();

        Thread.sleep(2000);
        //second one--> //h5[@class='swal-logo']//following-sibling::button

        driver.findElement(By.cssSelector("h5[class='swal-logo']~button")).click(); // second one

        WebElement popUpText = driver.findElement(By.cssSelector("div[class='swal-text']"));
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(popUpText), "Something went wrong!");
        Thread.sleep(1000);

        WebElement okButton = driver.findElement(By.cssSelector("button[class='swal-button swal-button--confirm']"));

        okButton.click();





    }
}
