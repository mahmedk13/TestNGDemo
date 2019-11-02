package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParameterization {
	
	
	public static WebDriver driver;
	@BeforeTest
	public void setUp() {
		
		}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@BeforeMethod
	public void navigateToFacebook() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://facebook.com");
	}
	
	@Test(dataProvider="getData")
	public void doLogin(String username, String password) {
		
		
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
		
		String sheetName = "LoginTest";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		
		System.out.println("Total rows are : "+rowNum+"  Total cols are : "+colNum);
		
		System.out.println(excel.getCellData(sheetName, 0, 2));
		
		Object[][] data = new Object[rowNum-1][colNum];
		
	/*	data[0][0] = excel.getCellData(sheetName, 0, 2);
		data[0][1] = excel.getCellData(sheetName, 1, 2);
		
		data[1][0] = excel.getCellData(sheetName, 0, 3);
		data[1][1] = excel.getCellData(sheetName, 1, 3);
		
		data[2][0] = excel.getCellData(sheetName, 0, 4);
		data[2][1] = excel.getCellData(sheetName, 1, 4);*/
		
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
			
				data[rows-2][cols]=excel.getCellData(sheetName, cols, rows);
				
				
			}
			
			
		}
		
		
		return data;
		
	}

}
