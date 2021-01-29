package tests.day8;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;

import java.util.List;

public class RadioButtons {
 private WebDriver driver;

    @BeforeMethod
    public void setUp(){
       driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Radio Buttons")).click();
    }

    @Test
    public void Test1(){

       WebElement blueButton = driver.findElement(By.id("blue"));
       boolean isSelected = blueButton.isSelected();
       Assert.assertTrue(isSelected);
    }

    @Test (description = "Verify that red button id not selected")
    public void Test2(){

        WebElement redButton = driver.findElement(By.id("red"));
        Assert.assertFalse(redButton.isSelected(), "is selected");
    }

    @Test (description = "Verify that green button id not clickable")
    public void Test3(){

        WebElement greenButton = driver.findElement(By.id("green"));
        Assert.assertFalse(greenButton.isEnabled());
    }

    @Test (description = "click on all radio buttons")
    public void test4(){
        List <WebElement> radioButtons = driver.findElements(By.cssSelector("input[type = 'radio']"));
        for (WebElement each: radioButtons){
            //if available for clicking and not selected yet
            if (each.isEnabled()&&!each.isSelected()){
                each.click();
                System.out.println("button clicked "+each.getAttribute("id"));
            }else{
                System.out.println("button is not clicked");
            }
        }
    }



    @AfterMethod
    public  void tearDown(){
        driver.quit();
    }
}
