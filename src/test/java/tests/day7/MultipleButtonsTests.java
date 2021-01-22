package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

public class MultipleButtonsTests {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
    }
@Test
public void verifyButton(){
        String expectedResult = "Clicked on button one!";
        driver.findElement(By.xpath("//*[text() = 'Button 1']")).click();
        String actualResult = driver.findElement(By.cssSelector("#result")).getText();
    Assert.assertEquals(actualResult,expectedResult,"wrong result");

}

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
