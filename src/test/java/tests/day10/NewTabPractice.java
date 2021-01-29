package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.Set;

public class NewTabPractice {
    //Windows switching

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
    }

    @Test
    public void test1() {
        driver.findElement(By.linkText("New tab")).click();

        BrowserUtils.wait(2);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Practice", "title is wrong");
    }

    @Test(description = "verify that user is able to see a new window")
    //every window gas an id. id calls window handle, we need to use the method getWindowHandle
    public void Test2() {
        driver.findElement(By.linkText("New tab")).click();
        String oldWindow = driver.getWindowHandle();
        BrowserUtils.wait(5);
        // after new window was open we can get the list of windows ID's

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            if (!each.equals(oldWindow)) {
                driver.switchTo().window(each);
            }
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Fresh tab", "title is wrong");

        String pageTitle = "Practice";
        for (String each : windowHandles) {
            driver.switchTo().window(each); // keep jumping from window to window unless window match with needed window
            if (driver.getTitle().equals(pageTitle)) {
                break;
            }
        }
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
