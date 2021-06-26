package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.UserManagement;

public class UserManagementTest extends BaseClass {
	
	Login login;
	UserManagement user;
	
  @Test(dataProvider="Sheet2", description = "Testing the Add User Button", priority=0)
  public void UMTest(String role, String name, String username, String status, String pass) {
	  
	  login = PageFactory.initElements(driver, Login.class);
	  user = PageFactory.initElements(driver, UserManagement.class);
	  
	  logger = report.createTest("User Management Test");
	  
	  login.enterUserName("admin");
	  logger.info("User entered username");
	  
	  login.enterPassword("admin123");
	  logger.info("User clicked Login button");
	  
	  user.ValidatepPage();
	  logger.pass("User validated site");
	  
	  user.clickUsertab();
	  logger.info("User hovered and clicked User Tab");
	  
	  user.clickAddButton();
	  logger.info("User clicked Add Button");
	  
	  user.selectRole(role);
	  logger.info("User selected a role");
	  
	  user.enterEmpName(name);
	  logger.info("User entered Employee name");
	  
	  user.enterUsername(username);
	  logger.info("User entered username");
	  
	  user.selectStatus(status);
	  logger.info("User selected status");
	  
	  user.enterPassword(pass);
	  logger.info("User entered and confirm password");
	  
	  user.clicksave();
	  logger.info("User clicked save button");
  }
	  
	  @DataProvider(name="Sheet2")
	  public Object[] [] getDataFromSources() throws FileNotFoundException, IOException
	  {
		  System.out.println("LOG:INFO Running Data Provider first to generate data");
		  
		  int rows = DataProviderFactory.getExcel().getRows("Sheet2"); //Gives a total number of rows
		  int columns = DataProviderFactory.getExcel().getColumns("Sheet2"); //Gives us the total number of columns
		  
		  System.out.println("Total number of rows: " + rows);
		  System.out.println("Total number of columns: " + columns);
		  
		  Object[][] arr = new Object[rows-1][columns]; //This is basically 1 row and 2 columns
		  
		  for(int i=0; i<rows-1; i++)
		  {
			  for(int j=0; j<columns; j++)
			  {
				  /*
				   * We are using i+1, because we don't want to use the first row. In order to minimize to spill over,
				   * we are also  doing rows-1, otherwise the i will throw array out of bound error
				   */
				  arr[i][j] = DataProviderFactory.getExcel().getCellData("Sheet2", i+1, j);
			  }
		  }
		  
		  System.out.println("LOG: INFO Data Provider is ready to use");
		  
		  return arr;	  
  }
}
