package tests.day9_review;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGReview {
    WebDriver driver;

    @BeforeMethod
    public void setup(){

    }
    // unit, integration, e2e
    @Test
    public void test1(){

    }

    @AfterMethod
    public void tearDown(){

    }
    @DataProvider (name = "testData")
    public static Object[] [] testData(){
return testData();
    }
}
