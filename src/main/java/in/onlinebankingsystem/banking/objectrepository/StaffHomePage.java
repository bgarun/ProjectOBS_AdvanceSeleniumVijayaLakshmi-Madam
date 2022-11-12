package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	
	@FindBy (name="viewdet")
	private WebElement viewactivecustomerbutton;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement viewcustomerbyaccountnumberbutton;
	
	@FindBy(name="apprvac")
	private WebElement approvependingaccountbutton;
	
	@FindBy(name="del_cust")
	private WebElement deletecustomeraccountnumberbutton;
	
	@FindBy(name="credit_cust_ac")
	private WebElement creditcustomerbutton;
	
	@FindBy(name="logout_btn")
	private WebElement stafflogoutbutton;
	
	@FindBy(name="home")
	private WebElement staffhomebutton;
	
	
	
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getViewactivecustomerbutton() {
		return viewactivecustomerbutton;
	}

	public WebElement getViewcustomerbyaccountnumberbutton() {
		return viewcustomerbyaccountnumberbutton;
	}

	public WebElement getApprovependingaccount() {
		return approvependingaccountbutton;
	}

	public WebElement getDeletecustomeraccountnumberbutton() {
		return deletecustomeraccountnumberbutton;
	}

	public WebElement getCreditcustomerbutton() {
		return creditcustomerbutton;
	}

	public WebElement getStafflogoutbutton() {
		return stafflogoutbutton;
	}

	public WebElement getStaffhomebutton() {
		return staffhomebutton;
	}
	
	public void approvependingaccount()
	{
		approvependingaccountbutton.click();
	}
    
	public void viewactivecustomer()
	{
		viewactivecustomerbutton.click();
	}
	
	public void stafflogout()
	{
		stafflogoutbutton.click();
	}
}
