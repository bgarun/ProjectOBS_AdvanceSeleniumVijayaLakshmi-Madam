package TestCases;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

import in.onlinebankingsystem.banking.objectrepository.AddBeneficiaryPage;
import in.onlinebankingsystem.banking.objectrepository.ApplyDebitCardPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferLoginPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.InternetBankingHomePage;
import in.onlinebankingsystem.banking.objectrepository.OtpConfirmationPage;

public class Test5 {

public static void main(String[] args) throws Throwable {
		
		//Random ran=new Random();
		//int random = ran.nextInt(10000);
		
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib= new Webdriver_Utilities();
		
				String BROWSER = flib.getDataFromPropertyFile("browser");
				String URL = flib.getDataFromPropertyFile("url");
				String UNC = flib.getDataFromPropertyFile("uncustomer");
				String PWDC = flib.getDataFromPropertyFile("pwdcustomer");
				
				String BNAME = elib.readdatafromExcel("sheet2", 0, 1);
				String BACCNO = elib.readdatafromExcel("sheet2", 1, 1);
				String IFSC = elib.readdatafromExcel("sheet2", 2, 1);
				String ACCTYPE = elib.readdatafromExcel("sheet2", 3, 1);
				String SELBE = elib.readdatafromExcel("sheet1", 0, 1);
				String AMT = elib.readdatafromExcel("sheet1", 1, 1);
				String RMS = elib.readdatafromExcel("sheet1", 2, 1);
				
				
				
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
				hp.applydebitcard();
				
				ApplyDebitCardPage adcp=new ApplyDebitCardPage(driver);
				adcp.accountholdername(elib.getList("sheet5"), driver);
				adcp.dateofbirth();
              
                Robot r=new Robot();
                r.keyPress(KeyEvent.VK_1);
                r.keyRelease(KeyEvent.VK_1);
                r.keyPress(KeyEvent.VK_1);
                r.keyRelease(KeyEvent.VK_1);
                r.keyPress(KeyEvent.VK_0);
                r.keyRelease(KeyEvent.VK_0);
                r.keyPress(KeyEvent.VK_4);
                r.keyRelease(KeyEvent.VK_4);
                r.keyPress(KeyEvent.VK_2);
                r.keyRelease(KeyEvent.VK_2);
                r.keyPress(KeyEvent.VK_0); 
                r.keyRelease(KeyEvent.VK_0);
                r.keyPress(KeyEvent.VK_2);
                r.keyRelease(KeyEvent.VK_2);
                r.keyPress(KeyEvent.VK_2);
                r.keyRelease(KeyEvent.VK_2);
               
                adcp.submit();
               Alert DC = driver.switchTo().alert();
                String PRINT = DC.getText();
                elib.writedatafromExcel("sheet3", 6, 1, PRINT);
                DC.accept();
                adcp.home();
                hp.internetbankinglogin(driver);
                FundTransferLoginPage ftlp=new FundTransferLoginPage(driver);
                ftlp.customerid(UNC, PWDC);
		       InternetBankingHomePage ibhp=new InternetBankingHomePage(driver);
		       ibhp.fundtransfer();
				FundTransferPage ftp=new FundTransferPage(driver);
				ftp.addbeneficiary();
				wlib.scrollBarAction(driver);
				AddBeneficiaryPage abp=new AddBeneficiaryPage(driver);
				abp.beneficiaryname(BNAME, BACCNO, IFSC);
				abp.acctypedropdown(ACCTYPE);
				Alert ADD = driver.switchTo().alert();
				String TE = ADD.getText();
				elib.writedatafromExcel("sheet3",8,1,TE);
				ADD.accept();
				abp.fundtransfer();
                wlib.scrollBarAction(driver);
                ftp.selectbeneficiary(SELBE, AMT, RMS);
			     OtpConfirmationPage ocp=new OtpConfirmationPage(driver);
			     Thread.sleep(15000);
			     ocp.verifybutton();
			     Alert POPUP = driver.switchTo().alert();
			     String PPOPUP = POPUP.getText();
			     elib.writedatafromExcel("sheet3", 9, 1, PPOPUP);
			     POPUP.accept();
			     ftp.myaccount();
                
	}

}
