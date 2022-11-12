package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApprovePendingAccountPage {

	@FindBy(name="application_no")
	private WebElement applicationnumbertextfield;
	
	@FindBy(name="search_application")
	private WebElement searchbutton;
	
	@FindBy(name="approve_cust")
	private WebElement approvebutton;
	
	@FindBy(name="logout_btn")
	private WebElement stafflogoutbutton;
	
	@FindBy(name="home")
	private WebElement staffhomebutton;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	
	public WebElement getHomemodule() {
		return homemodule;
	}


	public ApprovePendingAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getApplicationnumbertextfield() {
		return applicationnumbertextfield;
	}


	public WebElement getSearchbutton() {
		return searchbutton;
	}


	public WebElement getApprovebutton() {
		return approvebutton;
	}


	public WebElement getStafflogoutbutton() {
		return stafflogoutbutton;
	}


	public WebElement getStaffhomebutton() {
		return staffhomebutton;
	}
	
	public void applicationnumber(String text)
	{
		applicationnumbertextfield.sendKeys(text);
		searchbutton.click();
		
	}
	
	public void logout()
	{
		stafflogoutbutton.click();
		homemodule.click();
	}
	
	public void approveaccount()
	{
		approvebutton.click();
	}
	
}
