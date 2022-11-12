package testcasestestng;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import in.onlinebankingsystem.banking.objectrepository.OpenAccountConfirmationPage;
import in.onlinebankingsystem.banking.objectrepository.OpenAccountFormpage;
import in.onlinebankingsystem.banking.objectrepository.StaffHomePage;
import in.onlinebankingsystem.banking.objectrepository.StaffLoginPage;

public class Test6  extends BaseClass{
	
	@Test
	public void openAccount() throws EncryptedDocumentException, IOException, AWTException{


	String UNS = flib.getDataFromPropertyFile("unstaff");
	String PWDS = flib.getDataFromPropertyFile("pwdstaff");
	
	String GENDER = elib.readdatafromExcel("sheet7", 0, 1);
	String STATE = elib.readdatafromExcel("sheet7", 1, 1);
	String CITY = elib.readdatafromExcel("sheet7", 2, 1);
	String ACCTYPE = elib.readdatafromExcel("sheet7", 3, 1);
	String APPNO1 = elib.readdatafromExcel("sheet9", 0, 1);
	
	wlib.waitForPageLoad(driver);
	wlib.scrollBarAction(driver);
	HomePage hp=new HomePage(driver);
	hp.openaccount();
	wlib.scrollBarAction(driver);
	OpenAccountFormpage oafp=new OpenAccountFormpage(driver);
     oafp.openaccountpagemap(elib.getList("sheet8"), driver);
     oafp.openaccount(driver, GENDER, STATE, CITY, ACCTYPE);
     oafp.dateofbirth();
     Robot r=new Robot();
     r.keyPress(KeyEvent.VK_1);
     r.keyRelease(KeyEvent.VK_1);
     r.keyPress(KeyEvent.VK_1);
     r.keyRelease(KeyEvent.VK_1);
     r.keyPress(KeyEvent.VK_1);
     r.keyRelease(KeyEvent.VK_1);
     r.keyPress(KeyEvent.VK_0);
     r.keyRelease(KeyEvent.VK_0);
     r.keyPress(KeyEvent.VK_2);
     r.keyRelease(KeyEvent.VK_2);
     r.keyPress(KeyEvent.VK_0); 
     r.keyRelease(KeyEvent.VK_0);
     r.keyPress(KeyEvent.VK_2);
     r.keyRelease(KeyEvent.VK_2);
     r.keyPress(KeyEvent.VK_2);
     r.keyRelease(KeyEvent.VK_2);
  
     oafp.submit();
     OpenAccountConfirmationPage oacp=new OpenAccountConfirmationPage(driver);
     oacp.confirm();
	Alert APPNO = driver.switchTo().alert();
	String APNO = APPNO.getText();
    elib.writedatafromExcel("sheet3", 30, 5, APNO);
	APPNO.accept();
	hp.staffLogin();
	StaffLoginPage slp=new StaffLoginPage(driver);
	slp.stafflogin(UNS, PWDS);
	StaffHomePage shp=new StaffHomePage(driver);
	shp.approvependingaccount();
	ApprovePendingAccountPage apap=new ApprovePendingAccountPage(driver);
	apap.applicationnumber(APPNO1);
	apap.approveaccount();
	Alert REF = driver.switchTo().alert();
	String REFEX = REF.getText();
	elib.writedatafromExcel("sheet3", 31, 5, REFEX);
	REF.accept();
	apap.logout();
	slp.home();
	}	
}
