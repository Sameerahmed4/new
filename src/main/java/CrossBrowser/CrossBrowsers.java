package CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsers {

    WebDriver driver;

    @Test(dataProvider = "browserProvider")
    public void loginFacebook(String browser) {

        // Setup browser drivers using WebDriverManager
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // Open Facebook and perform login
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("your_email_here");
        driver.findElement(By.id("pass")).sendKeys("your_password_here");
        driver.findElement(By.name("login")).click();

        // Optional: Add assertion or wait

        driver.quit();
    }

    @DataProvider(name = "browserProvider")
    public Object[][] getBrowser() {
        return new Object[][] {
            {"chrome"},
            {"firefox"}
        };
    }
}
