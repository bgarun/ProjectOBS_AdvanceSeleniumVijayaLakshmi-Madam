package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class FundTransferPage extends Webdriver_Utilities {

	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staffloginmodule;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	@FindBy(xpath="//li[text()='My Account']")
	private WebElement myaccountmodule;
	
	@FindBy(xpath="//li[text()='My Profile']")
	private WebElement myprofilemodule;
	
	@FindBy(xpath="//li[text()='Change Password']")
	private WebElement changepasswordmodule;
	
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement fundtransfermodule;
	
	@FindBy(xpath="//li[text()='Statement']")
	private WebElement statementmodule;
	
	@FindBy(name="home")
	private WebElement homebuttonincustomer;
	
	@FindBy(name="logout_btn")
	private WebElement logotbuttonincustomer;
	
	@FindBy(name="add_beneficiary")
	private WebElement addbeneficiarybutton;
	
	@FindBy(name="delete_beneficiary")
	private WebElement deletebeneficiarybutton;
	
	@FindBy(name="view_beneficiary")
	private WebElement viewbeneficiarybutton;
	
	@FindBy(name="beneficiary")
	private WebElement selectbeneficiarydropdown;
	
	@FindBy(name="trnsf_amount")
	private WebElement amounttextfield;
	
	@FindBy(name="trnsf_remark")
	private WebElement remarktextfield;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement sendbutton;
	
	public FundTransferPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaffloginmodule() {
		return staffloginmodule;
	}

	public WebElement getHomemodule() {
		return homemodule;
	}

	public WebElement getMyaccountmodule() {
		return myaccountmodule;
	}

	public WebElement getMyprofilemodule() {
		return myprofilemodule;
	}

	public WebElement getChangepasswordmodule() {
		return changepasswordmodule;
	}

	public WebElement getFundtransfermodule() {
		return fundtransfermodule;
	}

	public WebElement getStatementmodule() {
		return statementmodule;
	}

	public WebElement getHomebuttonincustomer() {
		return homebuttonincustomer;
	}

	public WebElement getLogotbuttonincustomer() {
		return logotbuttonincustomer;
	}

	public WebElement getAddbeneficiarybutton() {
		return addbeneficiarybutton;
	}

	public WebElement getDeletebeneficiarybutton() {
		return deletebeneficiarybutton;
	}

	public WebElement getViewbeneficiarybutton() {
		return viewbeneficiarybutton;
	}

	public WebElement getSelectbeneficiarydropdown() {
		return selectbeneficiarydropdown;
	}

	public WebElement getAmounttextfield() {
		return amounttextfield;
	}

	public WebElement getRemarktextfield() {
		return remarktextfield;
	}

	public WebElement getSendbutton() {
		return sendbutton;
	}
	
	public void addbeneficiary()
	{
		addbeneficiarybutton.click();
		
	}
	
	public void selectbeneficiary(String value,String amount,String remarks)
	{
		select(value, selectbeneficiarydropdown);
		amounttextfield.sendKeys(amount);
		remarktextfield.sendKeys(remarks);
		sendbutton.click();
	}
	public void customerlogout()
	{
		logotbuttonincustomer.click();
	}
	public void myaccount()
	{
		myaccountmodule.click();
		logotbuttonincustomer.click();
	}
}
