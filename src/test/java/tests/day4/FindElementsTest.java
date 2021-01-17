package tests.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class FindElementsTest {
    public static void main(String[] args) {
        // go to this webside
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");



//step 1. Open in Chrome and find locator for the element
//step 2. Create object of  WebElement and click the button
//step 3. Use Webelement and verify that page title did not change


        WebElement button = driver.findElement(By.id("form_submit")); // because it is an interface
       // click to the button
        button.click();


        BrowserUtils.wait(2);

        String actualTitle = driver.getTitle();
        String expectedTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("passed"); // the same and we stayed at the same page
        }else {
            System.out.println("failed");
            System.out.println("expected Title" + expectedTitle);
            System.out.println("actual Title"+actualTitle);
        }
// 8 locators: id, name, tagname, class, xpath, cssSelector,linktext,partiallinktext


    }
}
