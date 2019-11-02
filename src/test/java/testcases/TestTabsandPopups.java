package testcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static void main(String[] args) {

		

		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-infobars");
	
		



		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver,10);
		
		
		System.out.println("----Generating window ids from first window----");
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();
		String first_window = iterator.next();
		System.out.println(first_window);
		
	/*	while(iterator.hasNext()) {
			
			iterator.next();
		}*/
		
		/*
		 * 0 - first window - Raman - abc1
		 * 1 - second window - Rahul - abc2
		 * 2 - third - Rahul - abc1
		 * 
		 */
		
		driver.findElement(By.xpath("//*[@id=\"parentdiv\"]/img")).click();

		driver.findElement(By.id("loginsubmit")).click();
		

		
		System.out.println("----Generating window ids from second window----");
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
	
		System.out.println(iterator.next()); //1st window
		String second_window = iterator.next(); //2nd window
		System.out.println(second_window);
		

		
		driver.switchTo().window(second_window);
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).click();
	/*	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Read More"))).click();
	*/	
		//driver.findElement(By.xpath("//*[@id=\"customertab1\"]/div[1]/div[2]/p[5]/strong/a")).click();
		
	
		System.out.println("----Generating window ids from third window----");
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
	
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		String third_window = iterator.next();
		System.out.println(third_window);

		driver.switchTo().window(third_window);
		
		
		System.out.println(driver.getTitle().contains("HDFC Bank | Customer Testimonials"));
		
		/*driver.close(); //3rd
		driver.switchTo().window(second_window);
		driver.close();*/
		
		driver.quit();
		
	}

}
