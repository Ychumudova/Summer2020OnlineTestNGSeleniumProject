package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class CheckBoxes {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    @Test
    public void Test1() {

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        int index = 1;
        for (WebElement each : checkboxes) {
            if (each.isEnabled() && !each.isSelected()) {
                each.click();
                System.out.println("checkboxes # " + index+" was clicked");
            } else {
                System.out.println("Checkboxes #  "+index+" was not clicked");
            }
            index++;
        }

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
