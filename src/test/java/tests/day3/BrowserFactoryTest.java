package tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserFactory;

public class BrowserFactoryTest {
    public static void main(String[] args) {
        // wew can get the webdriver method
        WebDriver driver = BrowserFactory.getDriver("chrome");
        // print the sourse code

        driver.get ("http://practice.cybertekschool.com");
        System.out.println(driver.getPageSource());

        driver.quit();
    }
}
