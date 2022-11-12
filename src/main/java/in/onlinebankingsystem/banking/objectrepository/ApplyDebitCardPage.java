package in.onlinebankingsystem.banking.objectrepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ApplyDebitCardPage {

	@FindBy(name="holder_name")
	private WebElement accountholdernametextfield;
	
	@FindBy(name="dob")
	private WebElement dateofbirthtextfield;
	
	@FindBy(name="pan")
	private WebElement pantextfield;
	
	@FindBy(name="mob")
	private WebElement registredmobilenumber;
	
	@FindBy(name="acc_no")
	private WebElement accountnumbertextfield;
	
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staffloginmodule;
	
	@FindBy(xpath="//a[text()='Home']")
	private WebElement homemodule;
	
	@FindBy(name="dbt_crd_submit")
	private WebElement submitbutton;
	
	public WebElement getSubmitbutton() 
	{
		return submitbutton;
	}

	public ApplyDebitCardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccountholdernametextfield() {
		return accountholdernametextfield;
	}

	public WebElement getDateofbirthtextfield() {
		return dateofbirthtextfield;
	}

	public WebElement getPantextfield() {
		return pantextfield;
	}

	public WebElement getRegistredmobilenumber() {
		return registredmobilenumber;
	}

	public WebElement getAccountnumbertextfield() {
		return accountnumbertextfield;
	}

	public WebElement getStaffloginmodule() {
		return staffloginmodule;
	}

	public WebElement getHomemodule() {
		return homemodule;
	}
	
	/*public void accoutholdername(String accholdername,String pan,String mobilenumber,String accnumber)
	{
		accountholdernametextfield.sendKeys(accholdername);
		pantextfield.sendKeys(pan);
		registredmobilenumber.sendKeys(mobilenumber);
		accountnumbertextfield.sendKeys(accnumber);
		
	}*/
	
	public void accountholdername(Map<String,String> map,WebDriver driver)
	{
		for(Entry <String ,String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		
	}
	
	public void dateofbirth()
	{
		dateofbirthtextfield.click();
	}
	
	public void submit()
	{
		submitbutton.click();
		
	}
	public void home()
	{
		homemodule.click();
	}
}
