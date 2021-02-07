package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
// constructor if you want to use the @FINDBY

public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    public WebElement userNameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement submitButton; // didn't use because of the KEYS.ENTER

    @FindBy(css = "[class='alert alert-error']") //Invalid user name or password.
    public WebElement warningMessage;


    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);//this - current page (current class)

    }

    public void login(String userName, String password) {
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password, Keys.ENTER); // substitute login click


    }
}
