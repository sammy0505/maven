package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.utility;

public class Logout {
	
	WebDriver driver;
	
	public Logout(WebDriver d)
	{
		this.driver = d;
	}
	
	@FindBy(id = "welcome") WebElement welcomeButton;
	@FindBy(xpath = "//*[@id='welcome-menu']/ul/li[3]/a") WebElement logoutButton;
	
	public void ClickLogout()
	{
		utility.waitForWebElement(driver, welcomeButton).click();
		utility.waitForWebElement(driver, logoutButton).click();
		
		System.out.println("LOG: INFO Clicked on logout button");
	}

}
