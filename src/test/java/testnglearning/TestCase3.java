package testnglearning;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test(priority=1)
	public void doUserReg() {
		
		Assert.fail("User not registered successfully");

		System.out.println("Executing user reg test");
	}
	
	
	@Test(priority=2,dependsOnMethods= "doUserReg")
	public void doLogin() {
		
		System.out.println("Executing login test");
		
	}

	@Test(priority=3)
	public void isSkip() {
		
		throw new SkipException("Skipping the test as the condition is not met");
	}
}
