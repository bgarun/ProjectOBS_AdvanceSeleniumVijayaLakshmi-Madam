package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountConfirmationPage {

	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staffloginmodule;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	@FindBy(name="cnfrm-submit")
	private WebElement confirmbutton;
	
	@FindBy(xpath="//input[@value='Go back']")
	private WebElement gobackbutton;
	
	public OpenAccountConfirmationPage(WebDriver driver)
	{
	  PageFactory.initElements(driver, this);
	}

	public WebElement getStaffloginmodule() {
		return staffloginmodule;
	}

	public WebElement getHomemodule() {
		return homemodule;
	}

	public WebElement getConfirmbutton() {
		return confirmbutton;
	}

	public WebElement getGobackbutton() {
		return gobackbutton;
	}
	
	
	public void confirm()
	{
		confirmbutton.click();
	}
	public void home()
	{
		homemodule.click();
	}
	
}
