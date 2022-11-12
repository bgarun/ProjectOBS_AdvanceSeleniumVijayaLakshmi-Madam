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

import in.onlinebankingsystem.banking.objectrepository.ApprovePendingAccountPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.StaffHomePage;
import in.onlinebankingsystem.banking.objectrepository.StaffLoginPage;
import in.onlinebankingsystem.banking.objectrepository.ViewActiveCustomerPage;

public class Test4 extends BaseClass{
	
	@Test(groups = "smoke")
	public void staffLoginApprovePendingAccount() throws IOException, InterruptedException {
		
		
	String UNS=flib.getDataFromPropertyFile("unstaff");
	String PWDS=flib.getDataFromPropertyFile("pwdstaff");
	String APPNO=elib.readdatafromExcel("sheet4", 0, 1);
	
	wlib.waitForPageLoad(driver);
	HomePage hp=new HomePage(driver);
	hp.staffLogin();
    StaffLoginPage slp=new StaffLoginPage(driver);
    slp.stafflogin(UNS, PWDS);
    StaffHomePage shp=new StaffHomePage(driver);
    shp.viewactivecustomer();
    ViewActiveCustomerPage vap=new ViewActiveCustomerPage(driver);
    vap.home();
    hp.staffLogin();
    shp.approvependingaccount();
    ApprovePendingAccountPage apap=new ApprovePendingAccountPage(driver);
    apap.applicationnumber(APPNO);
    apap.approveaccount();
    Alert POPUP = driver.switchTo().alert();
    String PRINT = POPUP.getText();
    elib.writedatafromExcel("sheet3", 36, 5, PRINT);
    POPUP.accept();
    shp.stafflogout();
    slp.home();
}
}
