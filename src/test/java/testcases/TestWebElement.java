package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebElement {

	public static String browser = "firefox";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.get("http://gmail.com");
		String title = driver.getTitle();
		System.out.println(title.length());
		System.out.println(title);

		// driver.close(); //current window
		driver.quit(); // current window + all related browsers in current session
	}

}
