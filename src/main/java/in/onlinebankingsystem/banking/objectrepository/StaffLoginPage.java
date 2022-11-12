package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {

	@FindBy(name="staff_id")
	private WebElement staffidtextfield;
	
	@FindBy(name="password")
	private WebElement passwordtestfield;
	
	@FindBy(name="staff_login-btn")
	private WebElement staffloginbutton;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getStaffidtextfield() {
		return staffidtextfield;
	}

	

	public WebElement getHomemodule() {
		return homemodule;
	}


	public WebElement getPasswordtestfield() {
		return passwordtestfield;
	}


	public WebElement getStaffloginbutton() {
		return staffloginbutton;
	}
	
	//Business libraries 
	public void stafflogin(String staffusername,String staffpassword)
	{
		staffidtextfield.sendKeys(staffusername);
		passwordtestfield.sendKeys(staffpassword);
		staffloginbutton.click();
	}
	
	public void home()
	{
		homemodule.click();
	}
	
}

