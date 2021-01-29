package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
    }

    @Test
    public void test() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // apply it once
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }

    @Test
    public void Test2() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.tagName("button")).click();

        // explicit wait

        WebElement userNameInputBox = driver.findElement(By.id("username"));
        WebDriverWait wait = new WebDriverWait(driver, 10); // wait up to 10 seconds until element is visible
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        System.out.println(driver.findElement(By.id("flash-messages")).getText());

        WebElement message = driver.findElement(By.tagName("h4"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actuallMessage = message.getText();
        Assert.assertEquals(actuallMessage, expectedMessage, "test failed");
    }

    @Test
    public void test3() {
        driver.findElement(By.linkText("Dynamic Loading")).click();
        driver.findElement(By.partialLinkText("Example 5")).click();


        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement overlayScreen = driver.findElement(By.cssSelector("[class='fa fa-cog fa-spin']"));
        wait.until(ExpectedConditions.invisibilityOf(overlayScreen));

        WebElement userNameInputBox = driver.findElement(By.id("username"));
        // wait up to 10 seconds until element is visible
        wait.until(ExpectedConditions.visibilityOf(userNameInputBox));
        userNameInputBox.sendKeys("tomsmith");

        WebElement passwordInputBox = driver.findElement(By.id("pwd"));
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        passwordInputBox.sendKeys("SuperSecretPassword");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        System.out.println(driver.findElement(By.id("flash-messages")).getText());

        WebElement message = driver.findElement(By.tagName("h4"));
        String expectedMessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actuallMessage = message.getText();
        Assert.assertEquals(actuallMessage, expectedMessage, "test failed");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
