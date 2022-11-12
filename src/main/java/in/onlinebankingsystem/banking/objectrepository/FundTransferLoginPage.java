package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferLoginPage {

	@FindBy (name="customer_id")
	private WebElement customeridtextfield;
	
	@FindBy (name="password")
	private WebElement customerpasswordtextfield;
	
	@FindBy (name="login-btn")
	private WebElement customerloginbutton;
	
	@FindBy (xpath="//label[text()='FORGET PASSWORD ?']")
	private WebElement forgotpasswordlink;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	public FundTransferLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomeridtextfield() {
		return customeridtextfield;
	}

	public WebElement getCustomerpasswordtextfield() {
		return customerpasswordtextfield;
	}

	public WebElement getCustomerloginbutton() {
		return customerloginbutton;
	}

	public WebElement getForgotpasswordlink() {
		return forgotpasswordlink;
	}

	public WebElement getHomemodule() {
		return homemodule;
	}
	
	public void customerid(String customerusername,String customerpassword)
	{
		customeridtextfield.sendKeys(customerusername);
		customerpasswordtextfield.sendKeys(customerpassword);
		customerloginbutton.click();
	}
	public void home()
	{
		homemodule.click();
	}
	
}
