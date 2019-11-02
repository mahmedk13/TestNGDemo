package testnglearning;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterizingXML {
	
	@Parameters({ "browser","url" })
	@Test
	public void launchBrowser(String browser,String url) throws InterruptedException {
		
		Date d = new Date();
		
		System.out.println(browser+"----"+url+"----"+d.toString());
		
		Thread.sleep(2000);
		
	}

}
