package tests.day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

import java.util.List;

public class DropDowns {

    private WebDriver driver;

    // <select id="dropdown">
    //      <option value="" disabled="disabled" selected="selected">Please select an option</option>
    //      <option value="1">Option 1</option>
    //      <option value="2">Option 2</option>
    //    </select>


    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Dropdown")).click();
    }

    @Test(description = "select option 2 from the dropdown")
    public void Test1() {
        //find a dropdowns
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

        BrowserUtils.wait(2);
// how to verify
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Option 2");
    }

    @Test(description = "select 03/30/1987 from the dropdown")
    public void Test2() {
        WebElement dropdownYear = driver.findElement(By.id("year"));
        Select selectYear = new Select(dropdownYear);
        selectYear.selectByVisibleText("1987");
        BrowserUtils.wait(2);

        WebElement dropdownMonth = driver.findElement(By.id("month"));
        Select selectMonth = new Select(dropdownMonth);
        selectMonth.selectByVisibleText("March");
        BrowserUtils.wait(2);

        WebElement dropdownDay = driver.findElement(By.id("day"));
        Select selectDay = new Select(dropdownDay);
        selectDay.selectByIndex(29);
        BrowserUtils.wait(2);

    }

    @Test(description = "print list of states")
    public void Test3() {
        WebElement state = driver.findElement(By.id("state"));

        Select select = new Select(state);

        List<WebElement> states = select.getOptions();

        for (WebElement each : states) {
            System.out.println(each.getText());
        }
    }

    @Test(description = "select your state and verify that state is selected")
    public void Test4() {
        WebElement state = driver.findElement(By.id("state"));

        Select select = new Select(state);
        select.selectByValue("MD");

        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Maryland");


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

