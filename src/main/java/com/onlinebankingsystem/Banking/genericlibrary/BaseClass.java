package com.onlinebankingsystem.Banking.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;




public class BaseClass {

	public Database_Utilities dlib=new Database_Utilities();
	public File_Utilities flib=new File_Utilities();
	public Excel_Utilities elib=new Excel_Utilities();
	public Java_Utilities jlib=new Java_Utilities();
	public Webdriver_Utilities wlib=new Webdriver_Utilities();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups ={"smoke","regression"})
	public void connectToDB() throws Throwable
	{
		dlib.connectToDb();
		System.out.println("database connected sucessfully");
	}
	
	
	@BeforeClass(groups ={"smoke","regression"})
	public void launchBrowser(/*String BROWSER*/) throws Throwable
	{
		
	   String	BROWSER=flib.getDataFromPropertyFile("browser");
	    
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	//WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	//WebDriverManager.firefoxdriver().setup();
	    	
	    }
	    else
	    {
	    	System.out.println("invalid browser");
	    }
	    
	   String URL = flib.getDataFromPropertyFile("url");
	    driver.get(URL);
	    driver.manage().window().maximize();
	    
	   
	    
	}
	 
	/*@BeforeMethod
	public void loginAsStaff() throws Throwable
	{
		driver.manage().window().maximize();
	    wlib.waitForPageLoad(driver);
	    
		String UNC = flib.getDataFromPropertyFile("uncustomer");
		String PWDC=flib.getDataFromPropertyFile("pwdcustomer");
		StaffLoginPage slp=new StaffLoginPage(driver);
		slp.stafflogin(UNC, PWDC);
		
	}*/
	
/*	@AfterMethod(groups ={"smoke","regression"})
	public void logout()
	{
		StaffHomePage shp=new StaffHomePage(driver);
		shp.stafflogout();
		System.out.println("staff logout has done sucessfully ");
	}*/
	
	@AfterClass(groups ={"smoke","regression"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("browser closed sucessfully");
	}
	
	@AfterSuite(groups ={"smoke","regression"})
	public void closeDB() throws Throwable
	{
		dlib.closeDB();
		System.out.println("database closed sucessfully");
	}
	
	
}
