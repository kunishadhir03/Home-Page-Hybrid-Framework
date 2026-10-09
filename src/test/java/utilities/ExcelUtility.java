package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static Object[][] getData() throws IOException{
		
		FileInputStream file = new FileInputStream("src\\test\\resources\\TestData\\SearchData.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		XSSFSheet sheet = wb.getSheet("SearchData");
		
		int rows = sheet.getLastRowNum();
		
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[rows][cols];
		
		for(int i = 1 ; i <= rows ; i++) {
			
			if(sheet.getRow(i) == null) {
				continue;
				}
			
			for(int j = 0 ; j < cols ; j++) {
				
				data[i-1][j] = sheet.getRow(i).getCell(j).toString();
				
			}
		}
		
		wb.close();
		
		return data ; 
	}

}
