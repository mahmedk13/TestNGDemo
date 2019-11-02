package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameterization {
	
	@Parameters({"url", "text"})
	@Test
	public void testmethod1(String url, String text) {
		
		WebDriver driver=null;
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		
		
			driver.get(url);
			driver.manage().window().maximize();
			driver.findElement(By.name("q")).sendKeys(text);

		
	}

}
