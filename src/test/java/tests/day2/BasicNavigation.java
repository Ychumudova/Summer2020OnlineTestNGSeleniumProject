package tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
// to maximize
        driver.manage().window().maximize();
        driver.get("http://google.com");
// to navigate to the different page
        driver.navigate().to("http://amazon.com");

// ti comeback to the previous page

        driver.navigate().back();
        String url = driver.getCurrentUrl();
        System.out.println(url);

        driver.quit(); // shuting down the browser and make it null

    }

}
