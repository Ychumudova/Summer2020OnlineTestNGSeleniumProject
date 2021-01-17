package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement inputText = driver.findElement(By.name("email"));
        BrowserUtils.wait(2);

        inputText.sendKeys("chumudova@gmail.com");

        WebElement button = driver.findElement(By.id("form_submit"));

        button.click();

        BrowserUtils.wait(2);

        // verify that URL has changed after clicking the button

        String actualURL = driver.getCurrentUrl();

        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        if (expectedURL.equals(actualURL)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        // verify that message is displayed


        driver.quit();
    }
}
