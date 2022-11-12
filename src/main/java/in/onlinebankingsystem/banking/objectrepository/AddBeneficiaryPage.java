package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class AddBeneficiaryPage  extends Webdriver_Utilities{

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
	
	@FindBy(name="beneficiary_name")
	private WebElement beneficiarynametextfield;
	
	@FindBy(name="beneficiary_acno")
	private WebElement beneficiaryaccountnumbertextfield;
	
	@FindBy(name="Ifsc_code")
	private WebElement ifsccodetextfield;
	
	@FindBy(name="beneficiary_acc_type")
	private WebElement accounttypedropdown;
	
	@FindBy(name="add_beneficiary_btn")
	private WebElement addbutton;
	
	public AddBeneficiaryPage(WebDriver driver)
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

	public WebElement getBeneficiarynametextfield() {
		return beneficiarynametextfield;
	}

	public WebElement getBeneficiaryaccountnumbertextfield() {
		return beneficiaryaccountnumbertextfield;
	}

	public WebElement getIfsccodetextfield() {
		return ifsccodetextfield;
	}

	public WebElement getAccounttypedropdown() {
		return accounttypedropdown;
	}

	public WebElement getAddbutton() {
		return addbutton;
	}
	
	public void beneficiaryname(String beneficiaryname,String beneficiaryaccountnumber,String ifsc)
	{
		beneficiarynametextfield.sendKeys(beneficiaryname);
		beneficiaryaccountnumbertextfield.sendKeys(beneficiaryaccountnumber);
		ifsccodetextfield.sendKeys(ifsc);
	   	
	}
	
	public void acctypedropdown(String value)
	{
		select(value, accounttypedropdown);
		    addbutton.click();
	}
	
	
	public void fundtransfer()
	{
		fundtransfermodule.click();
	}
}
