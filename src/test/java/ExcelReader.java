import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void main(String[] args) throws IOException {
		
		
		File f = new File("D:\\eclipse workspace\\TestNGDemo\\src\\test\\resources\\ExcelFiles\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		System.out.println("Sheet name is "+wb.getSheetName(0));
		Sheet sh = wb.getSheetAt(0);
		int totalRowNum = sh.getPhysicalNumberOfRows();
		System.out.println("total row numbers are "+sh.getPhysicalNumberOfRows());
		int cellNum = sh.getRow(0).getLastCellNum();
		System.out.println(sh.getRow(0).getCell(0));
		System.out.println(sh.getRow(3).getCell(1));

		
	}

}
