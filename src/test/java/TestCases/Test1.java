package TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

import in.onlinebankingsystem.banking.objectrepository.ChangePasswordChangePasswordPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferLoginPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.InternetBankingHomePage;

public class Test1 {


	public static void main(String[] args) throws Throwable {
		
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib= new Webdriver_Utilities();
		
		String BROWSER=flib.getDataFromPropertyFile("browser");
		String URL=flib.getDataFromPropertyFile("url");
		String UNC=flib.getDataFromPropertyFile("uncustomer");
		String PWDC=flib.getDataFromPropertyFile("pwdcustomer");
		String UPWDC=flib.getDataFromPropertyFile("updatepwd");
		
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else
		{
		
			System.out.println("Invalid browser");
		}
		driver.manage().window().maximize();
		driver.get(URL);
		wlib.waitForPageLoad(driver);
		wlib.scrollBarAction(driver);
		HomePage hp=new HomePage(driver);
		hp.fundtransfer();
		wlib.scrollBarAction(driver);
		FundTransferLoginPage ftlp = new FundTransferLoginPage(driver);
		ftlp.customerid(UNC, PWDC);
		InternetBankingHomePage ibhp=new InternetBankingHomePage(driver);
		ibhp.changepassword();
		ChangePasswordChangePasswordPage cpcpp=new ChangePasswordChangePasswordPage(driver);
		cpcpp.changepaswwordcustomer(PWDC,UPWDC);
		Alert CPWD = driver.switchTo().alert();
		String PRINT = CPWD.getText();
		elib.writedatafromExcel("sheet1", 15, 0, PRINT);
		CPWD.accept();
		cpcpp.logout();
		ftlp.home();
		hp.fundtransfer();
		wlib.scrollBarAction(driver);
		ftlp.customerid(UNC, UPWDC);
		
	}
}
