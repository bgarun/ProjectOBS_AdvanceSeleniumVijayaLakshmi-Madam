package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingHomePage {
	
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
	
	public InternetBankingHomePage(WebDriver driver)
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
	
	public void changepassword()
	{
		changepasswordmodule.click();
	}
	
	public void fundtransfer()
	{
		fundtransfermodule.click();
	}
	
	public void logout()
	{
		logotbuttonincustomer.click();
	}
	
	public void statement()
	{
		statementmodule.click();
		logotbuttonincustomer.click();
	}
	
	
}
