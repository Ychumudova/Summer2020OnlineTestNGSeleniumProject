package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class DragAndDropPractice {
    private WebDriver driver;

    @Test
    public void test() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/drag_and_drop");
        Actions action = new Actions(driver);

        WebElement A = driver.findElement(By.id("column-a"));
        WebElement B = driver.findElement(By.id("column-b"));
        action.dragAndDrop(A, B).perform();

        BrowserUtils.wait(2);
        driver.quit();
    }
}
