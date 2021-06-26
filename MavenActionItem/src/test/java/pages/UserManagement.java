package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import helper.utility;

public class UserManagement {
	
	WebDriver driver;
	
	public UserManagement(WebDriver d)
	{
	this.driver = d;
	}
	
	@FindBy(id = "menu_admin_viewAdminModule") WebElement adminTab;
	@FindBy(id = "menu_admin_UserManagement") WebElement managementTab;
	@FindBy(id = "menu_admin_viewSystemUsers") WebElement userTab;
	@FindBy(id = "btnAdd") WebElement addButton;
	
	@FindBy(id = "systemUser_userType") WebElement userRole;
	@FindBy(id = "systemUser_employeeName_empName") WebElement empName;
	@FindBy(id = "systemUser_userName") WebElement userName;
	@FindBy(id = "systemUser_status") WebElement status;
	@FindBy(id = "systemUser_password") WebElement password;
	@FindBy(id = "systemUser_confirmPassword") WebElement confPassword;
	@FindBy(id = "btnSave") WebElement saveButton;
	
	public void ValidatepPage()
	{
		utility.validateTitle(driver, "OrangeHRM");
	}
	
	public void clickUsertab()
	{
		Actions action = new Actions(driver);
		
		action.moveToElement(adminTab).build().perform();
		action.moveToElement(managementTab).build().perform();
		
		utility.waitForWebElement(driver, userTab).click();
		
		System.out.println("LOG: INFO Clicked on User button");
		
	 } 
	
	public void clickAddButton()
	{
		utility.waitForWebElement(driver, addButton).click();
		System.out.println("LOG: INFO CLicked in Add button");
	}
	
	public void selectRole(String role)
	{
		Select dropdown = new Select (userRole);
		
		//one way to select from dropdown
		if(role.equalsIgnoreCase("Admin"))
		{
			dropdown.selectByIndex(0);
		}
		else if(role.equalsIgnoreCase("ESS"))
		{
			dropdown.selectByIndex(1);
		}
		
		System.out.println("LOG: INFO User selected a role");
		
		//another way to select from dropdown
		//dropdown.selectByVisibleText(role);
	}
	
	public void enterEmpName(String name)
	{
		utility.waitForWebElement(driver, empName).sendKeys(name);
		System.out.println("LOG:INFO User entered a name");
	}
	
	public void enterUsername(String uname)
	{
		utility.waitForWebElement(driver, userName).sendKeys(uname);
		System.out.println("LOG:INFO User entered a username");
	}
	
	public void selectStatus(String stat)
	{
		Select dropdown = new Select(status);
		dropdown.selectByVisibleText(stat);
		System.out.println("LOG:INFO User selected a status");
	}
	
	public void enterPassword(String pass)
	{
		utility.waitForWebElement(driver, password).sendKeys(pass);
		utility.waitForWebElement(driver, confPassword).sendKeys(pass);
		System.out.println("LOG:INFO User entered and confirmed password");
	}
	
	public void clicksave()
	{
		utility.waitForWebElement(driver, saveButton).click();
		System.out.println("LOG:INFO User clicked save button");
	}
		
}
