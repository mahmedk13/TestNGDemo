package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebsite {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		// driver.manage().window().maximize();

		driver.manage().window().maximize();

		/*
		 * Options opt = driver.manage(); Window win = opt.window(); win.maximize();
		 */

		/*
		 * String title = driver.getTitle(); title.length();
		 */

		driver.getTitle().length();
		System.out.println(driver.getPageSource());

		/*
		 * WebElement username = driver.findElement(By.xpath("//*[@type='email']"));
		 * username.sendKeys("trainer@way2automation.com");
		 * 
		 * 
		 * WebElement button =
		 * driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span"));
		 * button.click();
		 */

	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='email']"))).sendKeys("trainer@way2automation.com");
		//driver.findElement(By.xpath("//*[@type='email']")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span")).click();
		// Thread.sleep(10000);
		//Thread.sleep(2000);
		
		
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("sdfsdfsfd");
		
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("asdfsdfs");

		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		System.out.println(driver.findElement(By.xpath(
				"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div[2]/div[2]/span"))
				.getText());
	}

}
