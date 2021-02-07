package tests.VyTrack;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utilities.Driver;

//first extend testBase class to inherit @Before and @After methods
public class LoginPageTests extends TestBase {

    @Test (description = "verify that page title is a Dashbord")
    public void test1(){
        LoginPage loginPage = new LoginPage(); // create the new page object
        loginPage.login("storemanager85", "UserUser123");
        Assert.assertEquals(Driver.get().getTitle(),"Dashboard");

    }

}
