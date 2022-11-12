package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

import in.onlinebankingsystem.banking.objectrepository.ApprovePendingAccountPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.StaffHomePage;
import in.onlinebankingsystem.banking.objectrepository.StaffLoginPage;
import in.onlinebankingsystem.banking.objectrepository.ViewActiveCustomerPage;

public class Test4 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib=new Webdriver_Utilities();
		String BROWSER = flib.getDataFromPropertyFile("browser");
		String URL=flib.getDataFromPropertyFile("url");
		String UNS=flib.getDataFromPropertyFile("unstaff");
		String PWDS=flib.getDataFromPropertyFile("pwdstaff");
		String APPNO=elib.readdatafromExcel("sheet4", 0, 1);
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
          elib.writedatafromExcel("sheet3", 0, 1, PRINT);
          POPUP.accept();
          shp.stafflogout();
          slp.home();
	}
}
