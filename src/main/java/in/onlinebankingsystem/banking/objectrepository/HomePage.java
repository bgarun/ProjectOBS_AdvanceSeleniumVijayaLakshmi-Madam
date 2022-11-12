package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class HomePage extends Webdriver_Utilities {
	
   //WebDriver driver=null;

	// Declaration
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staffloginmodule;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	@FindBy(xpath="//li[text()='Open Account']")
	private WebElement openaccountbutton;
	
	@FindBy(xpath="//li[text()='Apply Debit Card']")
	private WebElement applydebitcardbutton;
	
	@FindBy(xpath="//a[contains(text(),'Internet Banking')]")
	private WebElement internetbaningbutton;
	
	@FindBy(xpath="//li[text()='Register']")
	private WebElement internetbankingregisterbutton;
	
	@FindBy(xpath="//li[text()='Login ']")
	private WebElement internetbankingloginbutton;
	
	@FindBy(xpath="//li[text()='Fund Transfer']")
	private WebElement fundtransferbutton;
	
	
	// Initialization
	public HomePage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getStaffloginmodule() {
		return staffloginmodule;
	}
	
	public WebElement getHomemodule() {
		return homemodule;
	}

	public WebElement getOpenaccountbutton() {
		return openaccountbutton;
	}

	public WebElement getApplydebitcardbutton() {
		return applydebitcardbutton;
	}

	public WebElement getInternetbaningbutton() {
		return internetbaningbutton;
	}

	public WebElement getInternetbankingregisterbutton() {
		return internetbankingregisterbutton;
	}

	public WebElement getInternetbankingloginbutton() {
		return internetbankingloginbutton;
	}
	

	public WebElement getFundtransferbutton() {
		return fundtransferbutton;
	}

	

	//Business libraries
	public void staffLogin()
	{
		staffloginmodule.click();
	}
	
	public void home()
	{
		homemodule.click();
		
	}
	
	public void openaccount()
	{
		openaccountbutton.click();
	}
	
	public void applydebitcard()
	{
		applydebitcardbutton.click();
	}
	
	public void fundtransfer()
	{
		fundtransferbutton.click();
	}
	
	public void internetbankingregister(WebDriver driver)
	{
		mouseHover(driver, internetbaningbutton);
		internetbankingregisterbutton.click();
	}
	
	public void internetbankinglogin(WebDriver driver)
	{
		mouseHover(driver, internetbaningbutton);
		internetbankingloginbutton.click();
	}
	

}
