package testcasestestng;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.onlinebankingsystem.Banking.genericlibrary.BaseClass;
import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

import in.onlinebankingsystem.banking.objectrepository.ChangePasswordChangePasswordPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferLoginPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.InternetBankingHomePage;

public class Test1 extends BaseClass {


    @Test(priority=1)
	public void changePasswordUpdatePassword() throws IOException
	{
		
		String UNC=flib.getDataFromPropertyFile("uncustomer");
		String PWDC=flib.getDataFromPropertyFile("pwdcustomer");
		String UPWDC=flib.getDataFromPropertyFile("updatepwd");
		
		HomePage hp=new HomePage(driver);
		hp.fundtransfer();
		FundTransferLoginPage ftlp = new FundTransferLoginPage(driver);
		ftlp.customerid(UNC, PWDC);
		
		InternetBankingHomePage ibhp=new InternetBankingHomePage(driver);
		ibhp.changepassword();
		
		ChangePasswordChangePasswordPage cpcpp=new ChangePasswordChangePasswordPage(driver);
		cpcpp.changepaswwordcustomer(PWDC,UPWDC);
		
		Alert CPWD = driver.switchTo().alert();
		String PRINT = CPWD.getText();
		elib.writedatafromExcel("sheet3", 44, 5, PRINT);
		CPWD.accept();
		cpcpp.logout();
		ftlp.home();
		hp.fundtransfer();
		wlib.scrollBarAction(driver);
		ftlp.customerid(UNC, UPWDC);	
		
	}
    
}
