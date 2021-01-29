package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FraimsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/frames");
    }
    @Test
    public void test(){
        driver.findElement(By.linkText("iFrame")).click();

        driver.switchTo().frame("mce_0_ifr");
        WebElement inputArea = driver.findElement(By.id("tinymce"));

        String expectedText = "Your content goes here.";
        String actualText = inputArea.getText();
        Assert.assertEquals(actualText,expectedText);

        BrowserUtils.wait(4);
        inputArea.clear();
        BrowserUtils.wait(4);
        inputArea.sendKeys("java is fan");

        driver.switchTo().defaultContent();

    }
    @Test
    public void test2(){
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("[name='frame-bottom']")));
        WebElement content = driver.findElement(By.tagName("body"));
        System.out.println(content.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.tagName("body")).getText());


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
