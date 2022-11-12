package in.onlinebankingsystem.banking.objectrepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;



public class OpenAccountFormpage  extends Webdriver_Utilities{

	@FindBy(name="submit")
	private WebElement submitbutton;
	
	@FindBy(name="gender")
	private WebElement genderdropdown;
	
	@FindBy (name="state")
	private WebElement statedropdown;
	
	@FindBy (name="city")
	private WebElement citydropdown;
	
	@FindBy (name="acctype")
	private WebElement accounttypedropdown;
	
	@FindBy(name="dob")
	private WebElement dateofbirthtextfield;
	
	public OpenAccountFormpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public WebElement getGenderdropdown() {
		return genderdropdown;
	}

	public WebElement getStatedropdown() {
		return statedropdown;
	}

	public WebElement getCitydropdown() {
		return citydropdown;
	}

	public WebElement getAccounttypedropdown() {
		return accounttypedropdown;
	}
	
	public WebElement getDateofbirthtextfield() {
		return dateofbirthtextfield;
	}
	
	public void openaccount(WebDriver driver,String gender,String state,String city,String acctype)
	{
		
		select(gender, genderdropdown);
		select(state, statedropdown);
		select(city, citydropdown);
		select(acctype, accounttypedropdown);
		
	}
	
	public void dateofbirth()
	{
		dateofbirthtextfield.click();
	}
    
	public void submit()
	{
		submitbutton.click();
	}
	
	public void openaccountpagemap(Map<String,String> map,WebDriver driver)
	{
		for(Entry <String ,String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
	}
	
}
