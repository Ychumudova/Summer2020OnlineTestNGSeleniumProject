package tests.day7;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.BrowserFactory;

public class AnnotationsTests {

    @BeforeClass
    public  void beforeClass(){
        // runs only ones before the all methods
        System.out.println("BeforeClass runs only ones");
    }
    @AfterClass
    public  void afterClass(){
        // runs only ones before the all methods
        System.out.println("AfterClass runs only ones");
    }

    @BeforeMethod
   public void setup(){
       // some code will be running before every single tests, we can use @beforeMethod annotation
        System.out.println("Before method");
   }
   @AfterMethod
   public void tearDown(){
       System.out.println("After method");

}

    @Test
    public void test1(){
        System.out.println("Test1");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2() {
        System.out.println("Test2");
    }

    @Test

    public void test3(){
        System.out.println("Test3");
        }


    }

