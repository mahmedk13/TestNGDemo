package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver,5);
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(20))
		.pollingEvery(Duration.ofSeconds(5))
		.withMessage("Timed out after 20 seconds")
		.ignoring(NoSuchElementException.class);
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span")).click();
		
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("adsfsfdfss");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password123\"]/div[1]/div/div[1]/input"))).sendKeys("sadfsdfs");
		
		
		
		
	}

}
