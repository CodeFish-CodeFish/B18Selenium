package selenium.file_upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUpload {

    @Test
    public void validateUploadButton() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement fileUpload = driver.findElement(By.cssSelector("input[id='file-upload']"));
        Thread.sleep(2000);
        fileUpload.sendKeys("/Users/codefish/Desktop/download.png");

        driver.findElement(By.cssSelector("input[id='file-submit']")).click();

        WebElement successMsg = driver.findElement(By.tagName("h3"));

        String actualMsg = BrowserUtils.getText(successMsg);
        String expectedMsg = "File Uploaded!";

        Assert.assertEquals(actualMsg, expectedMsg);



    }

}
