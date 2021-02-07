package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {
    @BeforeMethod
    public void setup(){
        Driver.get().get(ConfigurationReader.getProperty("url"));

    }
    @AfterMethod
    public void tearDown(){
        Driver.close();

    }
}
