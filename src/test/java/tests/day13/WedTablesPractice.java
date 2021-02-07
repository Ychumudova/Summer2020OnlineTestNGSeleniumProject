package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class WedTablesPractice {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
    }

    @Test
    public void Test() {

        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }

    @Test
    public void Test2() {
        int actualColumnNumber = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
        int expected = 6;
        Assert.assertEquals(actualColumnNumber, expected);
    }

    @Test
    public void Test3() {
        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[2]//td"));
        for (WebElement each : row) {
            System.out.println(each.getText());
        }
    }

    @Test
    public void Test4() {

        List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[3]"));
        for (WebElement each : row) {
            System.out.println(each.getText());
            Assert.assertTrue(each.getText().contains("a"));
        }
    }

    @Test
    public void Test5() {
        WebElement lastName = driver.findElement(By.xpath("//table[@id='table1']//thead//tr//th[1]"));
        lastName.click();
        List<WebElement> FirstColumn = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[1]"));
        for (int i = 0; i < FirstColumn.size() - 1; i++) {
            String lastname = FirstColumn.get(i).getText();
            System.out.println(lastname);
            String followingLastName = FirstColumn.get(i + 1).getText();
            System.out.println(followingLastName);
            Assert.assertTrue(lastname.compareTo(followingLastName) < 0);

        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
