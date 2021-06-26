package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactory.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.Logout;


public class LoginTest extends BaseClass{
	
	Login login;
	Logout lout;
	
  @Test(description = "log in to OrangeHRM", priority = 0)
  
  public void LoginHRM() {
	  
	  login = PageFactory.initElements(driver, Login.class); //login login = new Login(driver);
	  
	  lout = PageFactory.initElements(driver, Logout.class); //Logout lout = new Logout (driver)
	  
	  logger = report.createTest("Login Test for OrangeHRM");
	  
	  login.ValidateHomepage();
	  
	  logger.pass("Home Page Validated");
	  
	  login.enterUserName("Admin");
	  
	  logger.info("Username entered");
	  
	  login.enterPassword("admin123");
	  
	  logger.info("Password Entered");
	  
	  login.ClickLoginButton();
	  
	  logger.info("Clicked on Login button");
	  
	  lout.ClickLogout();
	  
	  logger.info("Clicked in the Logout button");
	    
  }
  
  
  
  @Test(dataProvider = "Sheet1", description = "Log in to OrangeHRM using Excel", priority=1)
  public void LoginHRMExcel(String uname, String pass)
  {
	  login = PageFactory.initElements(driver, Login.class); //login login = new Login(driver);
	  
	  lout = PageFactory.initElements(driver, Logout.class); //Logout lout = new Logout (driver)
	  
	  logger = report.createTest("Login Test for OrangeHRM");
	  
	  login.ValidateHomepage();
	  
	  logger.pass("Home Page Validated");
	  
	  login.enterUserName(uname); //providing the username using Excel data
	  
	  logger.info("Username entered");
	  
	  login.enterPassword(pass); //Providing the password using excel data
	  
	  logger.info("Password Entered");
	  
	  login.ClickLoginButton();
	  
	  logger.info("Clicked on Login button");
	  
	  lout.ClickLogout();
	  
	  logger.info("Clicked in the Logout button"); 
  }
  
  @DataProvider(name="Sheet1")
  public Object[] [] getDataFromSources() throws FileNotFoundException, IOException
  {
	  System.out.println("LOG:INFO Running Data Provider first to generate data");
	  
	  int rows = DataProviderFactory.getExcel().getRows("Sheet1"); //Gives a total number of rows
	  int columns = DataProviderFactory.getExcel().getColumns("Sheet1"); //Gives us the total number of columns
	  
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
			  arr[i][j] = DataProviderFactory.getExcel().getCellData("Sheet1", i+1, j);
		  }
	  }
	  
	  System.out.println("LOG: INFO Data Provider is ready to use");
	  
	  return arr;
	  
  }
}
