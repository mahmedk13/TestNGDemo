package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {




		public static void main(String[] args) {



		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://gmail.com");

		driver.manage().window().maximize();



		Wait<WebDriver> wait = new FluentWait<WebDriver> (driver)

		.withTimeout(Duration.ofSeconds(30))

		.pollingEvery(Duration.ofSeconds(5))

		.withMessage("User-defined: Timed out after 30 seconds")

		.ignoring(NoSuchElementException.class);



		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='identifierId']")))

		//.sendKeys("kevin.sapp@clearavenue.com");

		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();



		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("tgsrtdyruy");

		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();



		//System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(

		//"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/span/div[1]/div[2]/div[2]/span")))

	//	.getText());



		}



		}


