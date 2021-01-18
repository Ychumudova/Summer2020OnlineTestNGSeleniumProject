package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class AbsoluteXpathTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("chumudova@gmail.com");
        driver.findElement(By.id("prependedInput2")).sendKeys("123");

        BrowserUtils.wait(2);
        driver.findElement(By.id("_submit")).click();

        BrowserUtils.wait(2);

        WebElement warningSign = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/fieldset/div[1]/div"));
        System.out.println(warningSign.getText());

        BrowserUtils.wait(2);
        driver.quit();

    }
}
