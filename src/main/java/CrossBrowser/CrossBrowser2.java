package CrossBrowser;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import org.testng.annotations.Parameters;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.AfterTest;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class CrossBrowser2 {

	    WebDriver driver;

	    @Parameters("browser")
	    @BeforeTest
	    public void setUp(String browserName) {
	        // Browser setup based on parameter
	        if (browserName.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();

	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();

	        } else {
	            throw new IllegalArgumentException("Invalid browser: " + browserName);
	        }

	        driver.manage().window().maximize();
	    }

	    @Test
	    public void loginTest() {
	        driver.get("https://www.facebook.com/");
	        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
	        driver.findElement(By.id("pass")).sendKeys("testpassword");
	        driver.findElement(By.name("login")).click();
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}


