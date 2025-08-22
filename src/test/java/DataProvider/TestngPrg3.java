package DataProvider;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;

	import io.github.bonigarcia.wdm.WebDriverManager;

	import java.time.Duration;

	public class TestngPrg3 {

	    WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.manage().window().maximize();
	        driver.get("https://www.facebook.com");
	    }

	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) {
	        driver.findElement(By.id("email")).sendKeys(username);
	        driver.findElement(By.id("pass")).sendKeys(password);
	        driver.findElement(By.name("login")).click();
	    }

	    @AfterMethod
	    public void teardown() {
	        driver.quit();
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return new Object[][] {
	            {"user1", "pass1"},
	            {"user2", "pass2"},
	            {"user3", "pass3"}
	        };
	    }
	}


