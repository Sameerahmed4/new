package Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;


	public class hardassert {

    @Test
    public void testTitle() {
        String actualTitle = "Log in to Facebook";
        String expectedTitle = "Facebook – log in or sign up";

        // This is a hard assertion
        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch!");
        
        // If assertion fails, below code will NOT execute
        System.out.println("This line will be skipped if assertion fails.");
    }
}

