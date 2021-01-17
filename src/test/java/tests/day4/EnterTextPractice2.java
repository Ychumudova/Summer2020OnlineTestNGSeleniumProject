package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class EnterTextPractice2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement inputText = driver.findElement(By.name("email"));
        BrowserUtils.wait(2);

        inputText.sendKeys("chumudova@gmail.com", Keys.ENTER);

        BrowserUtils.wait(2);

        // verify that URL has changed after clicking the button
        WebElement confirmationMessagemessage = driver.findElement(By.name("confirmation_message"));

        String expectedMessage = "Your e-mail's been sent!";

        String actualMessage = confirmationMessagemessage.getText(); // printing text on console

        if (expectedMessage.equals(actualMessage)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        driver.quit();
    }
}

