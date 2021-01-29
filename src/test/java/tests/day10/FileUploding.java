package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FileUploding {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test
    public void test() {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("/Users/yuliachumudova/Desktop/Reply_for_POLCCOC_request.pdf");
        driver.findElement(By.id("file-submit")).click();

        BrowserUtils.wait(2);
        String expectedFileName = "Reply_for_POLCCOC_request.pdf";
        String actualFileName = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actualFileName,expectedFileName);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
