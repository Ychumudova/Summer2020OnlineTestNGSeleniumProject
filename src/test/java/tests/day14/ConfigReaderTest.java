package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

public class ConfigReaderTest {
    @Test
    public void test1() {
        String expectedBrowser = "chrome";
        String actualBrowser = ConfigurationReader.getProperty("browser");// keys from configuration.properties
        Assert.assertEquals(actualBrowser, expectedBrowser);
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));
        System.out.println("Username: "+ ConfigurationReader.getProperty("user_name"));
        System.out.println("Password: "+ ConfigurationReader.getProperty("password"));

    }
}
