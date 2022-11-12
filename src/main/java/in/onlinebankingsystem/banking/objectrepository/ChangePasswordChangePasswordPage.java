package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordChangePasswordPage {

	@FindBy(name="oldpass")
	private WebElement oldpasswordtextfield;
	
	@FindBy(name="cnfrm")
	private WebElement confirmoldpasswordtextfield;
	
	@FindBy(name="newpass")
	private WebElement newpasswordtextfield;
	
	@FindBy(name="change_pass")
	private WebElement submitbutton;
	
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staffloginmodule;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	@FindBy(name="home")
	private WebElement homebuttonincustomer;
	
	@FindBy(name="logout_btn")
	private WebElement logoutbuttonincustomer;
	
	public ChangePasswordChangePasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOldpasswordtextfield() {
		return oldpasswordtextfield;
	}

	public WebElement getConfirmoldpasswordtextfield() {
		return confirmoldpasswordtextfield;
	}

	public WebElement getNewpasswordtextfield() {
		return newpasswordtextfield;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public WebElement getStaffloginmodule() {
		return staffloginmodule;
	}

	public WebElement getHomemodule() {
		return homemodule;
	}

	public WebElement getHomebuttonincustomer() {
		return homebuttonincustomer;
	}

	public WebElement getLogotbuttonincustomer() {
		return logoutbuttonincustomer;
	}
	
	public void changepaswwordcustomer(String customerchangepassword,String newpassword )
	{
		oldpasswordtextfield.sendKeys(customerchangepassword);
		confirmoldpasswordtextfield.sendKeys(customerchangepassword);
		newpasswordtextfield.sendKeys(newpassword);
		submitbutton.click();
	}
	public void logout()
	{
		logoutbuttonincustomer.click();
	}
	
	
	
	
	
	
	
	
	
	
}
