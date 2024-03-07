package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This will help us read data from excel and return us everything in object 2D array
//Our Test will always be focusing on Object 2D array (dataprovider)
public class ExcelReader {
	
	static XSSFWorkbook wb;
	
	public static Object [][] getDataFromSheet(String sheetName) {
		Object arr[][] = null;
		try {
			//load excel
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+ "/testdata/TestData.xlsx")));
			
			//load sheet
			XSSFSheet sheet =wb.getSheet(sheetName);
			
			//get rows
			int row = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows in sheet "+ row);
		
			//get columns
			int column = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Number of columns "+ column);
			
			
			//create array based on rows and columns from excel
			arr = new Object [row-1][column];
			
			for(int i=1;i<row;i++) {
				for(int j=0;j<column;j++) {
					arr[i-1][j]= getCellData(sheetName, i, j); 
				 }
				}
	
		} catch (FileNotFoundException e) {
			System.out.println("Excel file not found"+e.getMessage());

		} catch (IOException e) {
			System.out.println("Excel file not loaded"+e.getMessage());

		}
		return arr;
	
	}
	

	public static String getCellData(String sheetName,int row, int column){
		String data;
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(column);
		
		if(cell.getCellType()==CellType.STRING) {
			data = cell.getStringCellValue();
		}
		
		else if(cell.getCellType()==CellType.NUMERIC) {
			double dataInDouble= cell.getNumericCellValue();
			data = String.valueOf(dataInDouble);
		}
		
		else {
			data="";
		}
		
		return data;
	}
}
