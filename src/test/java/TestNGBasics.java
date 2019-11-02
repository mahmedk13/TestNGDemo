import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	
	@Test(dataProvider = "getData")
	public void testmethod(String browser, String url) {
		
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		}else {
			System.out.println("browser is not defined");
		}
		
		driver.get(url);
		driver.manage().window().maximize();

		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][2];
		
		data[1][0]="chrome";
		data[1][1]="http://www.google.com";
		
		data[0][0]="firefox";
		data[0][1]="http://www.facebook.com";
		
		return data;
		
	}

}
