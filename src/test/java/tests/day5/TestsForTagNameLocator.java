package tests.day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class TestsForTagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullName = driver.findElement(By.name("full_name"));

        fullName.sendKeys("Yulia Chumudova");

        BrowserUtils.wait(1);

        driver.findElement(By.name("email")).sendKeys("chumudova1987@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();

        BrowserUtils.wait(1);

        WebElement result = driver.findElement(By.tagName("h3"));

        System.out.println(result.getText());
        BrowserUtils.wait(2);

        driver.quit();
    }
}
