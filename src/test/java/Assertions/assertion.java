package Assertions;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;
	import org.testng.asserts.SoftAssert;
	import io.github.bonigarcia.wdm.WebDriverManager;

	import java.time.Duration;

	public class assertion {
		

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
	        SoftAssert soft = new SoftAssert();

	        driver.findElement(By.id("email")).sendKeys(username);
	        driver.findElement(By.id("pass")).sendKeys(password);
	        driver.findElement(By.name("login")).click();

	        // Wait a bit and check something (like error message)
	        try {
	            Thread.sleep(2000);  // Just for demo, replace with proper wait
	        } catch (InterruptedException e) {}

	        String currentUrl = driver.getCurrentUrl();
	        soft.assertTrue(currentUrl.contains("login"), "Login URL should still contain 'login' if login failed");

	        String title = driver.getTitle();
	        soft.assertEquals(title, "Facebook – log in or sign up", "Page title mismatch");

	        // Collect and report all soft assertion failures
	        soft.assertAll();
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        return new Object[][] {
	            {"user1@example.com", "wrongpass"},
	            {"user2@example.com", "wrongpass"},
	            {"invalid@example.com", "123456"}
	        };
	    }
	}

