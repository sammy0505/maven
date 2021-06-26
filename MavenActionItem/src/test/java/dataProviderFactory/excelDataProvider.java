package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelDataProvider {
	
	//If you are using .xls file, use HSSF
	//If you are using. xlsx file, use XSSF
	
	XSSFWorkbook wb;
	
	public excelDataProvider() throws FileNotFoundException, IOException {
		
		wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir") + "/testdata/TestDataUpdated.xlsx")));
		
		//Line 19 is basically the following in a single line
		
		/*
		 * 
		 * FileInputStream xlFIS = new FileInputStream(xlFile);
		 * XXSFWokrbook xlbook = new XSSFWorkbook(xlFIS);
		 * 
		 */
				
	}
	
	public String getCellData(String sheetName, int row, int col)
	{
		XSSFCell cell = wb.getSheet(sheetName).getRow(row).getCell(col);
		
		//Line 35 is basically the following in a single line
		
		/*
		 * XSSFSheet xlsheet = xlbook.getSheet("Sheet1");
		 * XSSFRow xlrow = xlsheet.getRow(0);
		 * XSSFCell xlcell = xlrow.getCell(0);
		 */
		
		String data = null;
		
		if(cell.getCellType() == CellType.STRING) //compares the cell value to see if it's a String
		{
			data = cell.getStringCellValue();
		}
		else if(cell.getCellType() == CellType.NUMERIC) //compares the cell value to see if it's a Number
		{
			data = String.valueOf((double)cell.getNumericCellValue());
		}
		if(cell.getCellType() == CellType.BLANK) //compares the cell value to see if it's blank
		{
			data = "";
		}
		return data; //return the cell data
		
	}
	
	public int getRows(String sheetName)
	{
		return wb.getSheet(sheetName).getPhysicalNumberOfRows(); //returns the total number of rows
	}
	
	public int getColumns(String sheetName)
	{
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells(); //returns the total number of columns in a row
	}

}
