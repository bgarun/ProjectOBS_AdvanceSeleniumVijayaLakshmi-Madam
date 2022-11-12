package in.onlinebankingsystem.banking.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewActiveCustomerPage {

	@FindBy(name="home")
	private WebElement homebuttonstaff;
	
	@FindBy(name="logout_btn")
	private WebElement logoutbuttonstaff;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	public ViewActiveCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomebuttonstaff() {
		return homebuttonstaff;
	}

	public WebElement getLogoutbuttonstaff() {
		return logoutbuttonstaff;
	}

	public WebElement getHomemodule() {
		return homemodule;
	}
	
	public void home()
	{
		homemodule.click();
	}
}
