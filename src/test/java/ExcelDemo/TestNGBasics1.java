package ExcelDemo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Test;

public class TestNGBasics1 {
	
	
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
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.linkedin.com/");
	}
	
	@Test(dataProvider="getData")
	public void doLogin(String username, String password) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(5000);
		
		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException{
		
		File f = new File("D:\\eclipse workspace\\TestNGDemo\\src\\test\\resources\\ExcelFiles\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		System.out.println("Sheet name is "+wb.getSheetName(0));
		Sheet sh = wb.getSheetAt(0);
		int totalRowNum = sh.getPhysicalNumberOfRows();
		System.out.println("total row numbers are "+sh.getPhysicalNumberOfRows());
		int cellNum = sh.getRow(0).getLastCellNum();
		System.out.println("total cols are "+cellNum);
		
		Object[][] data = new Object[totalRowNum-1][cellNum];
		
		for(int i=1; i<totalRowNum; i++) {
			for(int j=0; j<cellNum; j++) {
				data[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		return data;
		
	}

}
