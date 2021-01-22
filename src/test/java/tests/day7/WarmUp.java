package tests.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class WarmUp {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.cybertekschool.com/");
        BrowserUtils.wait(3);

        List <WebElement> links = driver.findElements(By.xpath("//a"));
        for (WebElement webElement: links) {
            System.out.println(webElement.getText());
        }
        System.out.println(links.size());


        driver.quit();
    }
}
