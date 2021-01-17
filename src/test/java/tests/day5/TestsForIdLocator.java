package tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class TestsForIdLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button = driver.findElement(By.id("disappearing_button"));
        button.click();
        BrowserUtils.wait(2);

        WebElement result = driver.findElement(By.id("result"));
        System.out.println(result.getText());



       driver.quit();

    }


}
