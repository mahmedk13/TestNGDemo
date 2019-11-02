package testnglearning;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void createDBConn() {
		
		System.out.println("Create DB Conn");
		
		
	}
	
	@AfterTest
	public void closeDBConn() {
		
		System.out.println("Close DB Conn");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		
		System.out.println("Launching the browser");
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		System.out.println("Closing the browser");
	}
	
	
	@Test(priority=1)
	public void doUserReg() {
		
		System.out.println("Executing user reg test");
	}
	
	
	@Test(priority=2)
	public void doLogin() {
		
		System.out.println("Executing login test");
		
	}
	
	

}
