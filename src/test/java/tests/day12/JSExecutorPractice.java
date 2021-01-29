package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class JSExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");

    }

    @Test
    public void Test1() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver; // create the object
// x-coordinate horizontal pixel, and y-vertical
        jse.executeScript("window.scrollBy(0,500)");
        BrowserUtils.wait(5);
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/large");
        WebElement element = driver.findElement(By.linkText("Cybertek School"));
        BrowserUtils.wait(2);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",element);
        BrowserUtils.wait(4);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
