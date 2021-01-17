package tests.day3;

import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class NavigationPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://google.com");

        driver.navigate().to("http://amazon.com");

        BrowserUtils.wait(2); // custom method for thread.sleep();

        System.out.println(driver.getTitle()); // get title from the page

        driver.navigate().back();

        BrowserUtils.wait(2);

        driver.navigate().forward(); // to amazon again

        BrowserUtils.wait(2);

        driver.navigate().refresh(); // refresh the page

        driver.quit(); // we can not all driver after quit it would be null!





    }
}
