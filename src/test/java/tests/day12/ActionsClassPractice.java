package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserFactory;
import utilities.BrowserUtils;

public class ActionsClassPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }
    @Test
    public void testHoverPractice(){ // hover = парить! не нажимать
        Actions action = new Actions(driver);

        WebElement image1 = driver.findElement(By.cssSelector(".figure:nth-of-type(1)"));
        action.moveToElement(image1).perform(); // built is we have more than one action
        BrowserUtils.wait(2);

        WebElement textOfImage = driver.findElement(By.cssSelector(".figure:nth-of-type(1) h5"));
        System.out.println(textOfImage.getText());

        String  expectedText = "name: user1";
        String actualText = textOfImage.getText();
        Assert.assertEquals(actualText,expectedText);


    }
    @Test
    public void HoverPractice2(){
        Actions action = new Actions(driver);

        for (int i =1; i<=3;i++){
            action.moveToElement(driver.findElement(By.cssSelector(".figure:nth-of-type("+i+")"))).perform();
            BrowserUtils.wait(3);
            String image = driver.findElement(By.cssSelector(".figure:nth-of-type("+i+") h5")).getText();
            System.out.println(image);
            Assert.assertEquals(image, "name: user"+i);
        }
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
