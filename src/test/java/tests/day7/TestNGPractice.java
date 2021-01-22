package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class TestNGPractice {

    @Test
    public void test(){

        Assert.assertEquals("apple","apple", "word is not correct");

    }
    @Test (description = "Verifying title of the practice website")
public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        String actualTitle = "Practice";
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle, "Title is wrong, not equal");
        driver.quit();
}
@Test (description = "verifying that heading is displayed")
public void verifyHeadingIsDisplayed(){
    WebDriver driver = BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/");
    WebElement heading = driver.findElement(By.xpath("//span[text() = \"Test Automation Practice\"]"));
    Assert.assertTrue(heading.isDisplayed(),"element is not visible");



    driver.quit();
}
}
