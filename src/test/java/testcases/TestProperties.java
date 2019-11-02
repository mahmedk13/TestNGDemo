package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestProperties.class.getSimpleName());
	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	
	
	//driver.findElement(By.xpath(OR.getProperty("username_XPATH"))).click();

	public static void click(String locator) {

		try {
		if (locator.endsWith("_ID")) {

			driver.findElement(By.id(or.getProperty(locator))).click();

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(or.getProperty(locator))).click();

		} else if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(or.getProperty(locator))).click();

		}
		
		log.info("Clicking on an Element :  " + locator);

		}catch(Throwable t) {
			
			log.error("Error while clicking the element : "+locator+" the error message is : "+t.getMessage());
		}
	
	
	
	}

	public static void type(String locator, String value) {

		try {
		if (locator.endsWith("_ID")) {

			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);

		}}catch(Throwable t) {
			
			log.error("Error while typing in an element : "+locator+" the error message is : "+t.getMessage());
		}
		
		
		log.info("Typing in an Element :  " + locator
		+ " Entered the value as : "+value);

	}

	/*
	 * Apache Log4j - jar Logger class Log4j Appenders - log4j.properties
	 * PropertyConfigurator
	 * 
	 */

	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		or.load(fis);
		log.info("OR Properties file loaded !!!");

		fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		config.load(fis);
		log.info("Config Properties file loaded !!!");

		// driver.get(config.getProperty("testsiteurl"))
		System.out.println(config.getProperty("testsiteurl"));
		// driver.findElement(By.id(or.getProperty("username_ID"))).sendKeys(value)
		System.out.println(or.getProperty("username_ID"));

		if (config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome launched !!!");

		} else if (config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox launched !!!");

		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to : " + config.getProperty("testsiteurl"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicit.wait")));

		type("username_ID", "trainer@way2automation.com");
		click("nextBtn_XPATH");
	

		
		driver.quit();
		log.info("Test execution completed !!!");

	}

}
