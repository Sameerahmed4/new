package BasicsTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngPrg1 {

	   @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("Before Suite: Runs before all tests in the suite");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite: Runs after all tests in the suite");
	    }

	    @BeforeTest
	    public void beforeTest() {
	        System.out.println("Before Test: Runs before <test> tag in testng.xml");
	    }

	    @AfterTest
	    public void afterTest() {
	        System.out.println("After Test: Runs after <test> tag in testng.xml");
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("Before Class: Runs before the first method in the class");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("After Class: Runs after all methods in the class");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("Before Method: Runs before each @Test method");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("After Method: Runs after each @Test method");
	    }

	    @Test(groups ="module1",dependsOnGroups="module2")
	    public void test1() {
	        System.out.println("Test 1: Actual test code");
	    }

	    @Test(groups ="module2")
	    public void test2() {
	        System.out.println("Test 2: Actual test code");
	    }
	    @Test(groups ="module1")
	    public void test3() {
	        System.out.println("Test 3: Actual test code");
	    }
	    @Test(groups ="module2")
	    public void test4() {
	        System.out.println("Test 4: Actual test code");
	    }
	

}
