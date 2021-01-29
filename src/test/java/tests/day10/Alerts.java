package tests.day10;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class Alerts {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

    }

    @Test(description = "verify and click ok in pop-up message")
    public void test1() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[text() ='Click for JS Alert']")).click();

        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.accept(); // to click OK
        BrowserUtils.wait(2);
    }

    @Test(description = "verify and click CANCEL in pop-up message")
    public void test2() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.xpath("//button[2]")).click();

        BrowserUtils.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @Test(description = "click on button 3, enter some text that ckick ok")
    public void test3() {
        driver.findElement(By.linkText("JavaScript Alerts")).click();
        driver.findElement(By.cssSelector("button[onclick ='jsPrompt()']")).click();

        BrowserUtils.wait(2);
        driver.switchTo().alert().sendKeys("java");
        BrowserUtils.wait(5);
        driver.switchTo().alert().accept();
        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.id("result")).getText());
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
