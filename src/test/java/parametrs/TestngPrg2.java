package parametrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class TestngPrg2 {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path to your chromedriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com"); // Or any login URL you prefer
    }

    @Test
    @Parameters({"val1", "val2"})
    public void LoginFunction(String user, String pass) {
        driver.findElement(By.id("email")).sendKeys(user);
        driver.findElement(By.id("pass")).sendKeys(pass);
        driver.findElement(By.name("login")).click();
    }
}
