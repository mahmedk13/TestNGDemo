package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("Dansk");
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		//select.selectByIndex(2);
		
	/*	WebElement block1 = driver.findElement(By.xpath("//block"));
		
		block1.findElements(By.id("abc")).get(3).click();
		
		*/
		
	
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		
		System.out.println("Total values are : "+values.size());
		
		System.out.println(values.get(7).getText());
		
		
		//0 - less than size
		
		
		for(int i=0; i<values.size(); i++) {
			
			System.out.println(values.get(i).getAttribute("lang")+"---value---"+values.get(i).getAttribute("value")+"---text is---"+values.get(i).getText());
			
		}
		
		System.out.println("-----Printing all links-----");
		
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]"));
		
		
		
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println("Total links - > "+links.size());
		
		for(WebElement link: links) {
			
			System.out.println(link.getText()+"---URL IS---"+link.getAttribute("href"));
		}
		
		
		
	}

}
