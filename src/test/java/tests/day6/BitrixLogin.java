package tests.day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class BitrixLogin {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://login1.nextbasecrm.com/?login=yes");
        driver.findElement(By.xpath("//input[@name='USER_LOGIN']")).sendKeys("chumudova@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"USER_PASSWORD\"]")).sendKeys("123");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@class=\"login-btn\"]")).click();


        driver.quit();

    }
}
