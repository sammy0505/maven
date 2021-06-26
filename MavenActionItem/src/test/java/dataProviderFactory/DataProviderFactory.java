package dataProviderFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderFactory {
	
	public static configDataProvider getConfig() throws FileNotFoundException, IOException
	{
		configDataProvider config = new configDataProvider(); //Creates an object of the configdataProvider class to access the methods
		
		return config;
	}
	
	public static excelDataProvider getExcel() throws FileNotFoundException, IOException
	{
		excelDataProvider excel = new excelDataProvider(); //Creates an object of the exceldataProvider class to access the methods.
		
		return excel;
	}

}
