package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OtpConfirmationPage {

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

	@FindBy(name="verify-btn")
	private WebElement otpverifybutton;
	
	public OtpConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void verifybutton()
	{
		otpverifybutton.click();
	}
}
