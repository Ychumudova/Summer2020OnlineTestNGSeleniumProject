package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class CssSelectorPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-primary"));

        for (WebElement webElement: buttons) {
                webElement.click();
      
            BrowserUtils.wait(1);
           WebElement message= driver.findElement(By.cssSelector("#result"));
            System.out.println(message.getText());

        }
        WebElement header = driver.findElement(By.cssSelector(".container>h3"));
        System.out.println(header.getText());
        driver.quit();
    }
}
