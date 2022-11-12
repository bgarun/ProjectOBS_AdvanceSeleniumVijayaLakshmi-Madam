package TestCases;

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
import in.onlinebankingsystem.banking.objectrepository.FundTransferLoginPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.InternetBankingHomePage;
import in.onlinebankingsystem.banking.objectrepository.OtpConfirmationPage;

public class Test2  extends Webdriver_Utilities{

	public static void main(String[] args) throws Throwable {

		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib=new Webdriver_Utilities();
		
		String BROWSER=flib.getDataFromPropertyFile("browser");
		String URL=flib.getDataFromPropertyFile("url");
		String UNS=flib.getDataFromPropertyFile("unstaff");
		String PWDS=flib.getDataFromPropertyFile("pwdstaff");
		String UNC=flib.getDataFromPropertyFile("uncustomer");
		String PWDC=flib.getDataFromPropertyFile("pwdcustomer");
		String UPWDC=flib.getDataFromPropertyFile("updatepwd");
				
				
			
		String BNAME=elib.readdatafromExcel("sheet2", 0, 1);
		String BACCNO=elib.readdatafromExcel("sheet2", 1, 1);
		String IFSC=elib.readdatafromExcel("sheet2", 2, 1);
		String AMT=elib.readdatafromExcel("sheet1", 1, 1);
		String RMS=elib.readdatafromExcel("sheet1", 2, 1);
		String ACCTYPE=elib.readdatafromExcel("sheet2", 3, 1);
		String SELBEN=elib.readdatafromExcel("sheet1", 0, 1);
			
				
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
				elib.writedatafromExcel("sheet3", 4, 1, TE);
				ADD.accept();
				abp.fundtransfer();
                wlib.scrollBarAction(driver);
                ftp.selectbeneficiary(SELBEN, AMT, RMS);
				Thread.sleep(15000);//OTP ENTERING
				OtpConfirmationPage ocp=new OtpConfirmationPage(driver);
				ocp.verifybutton();
				Alert POPUP = driver.switchTo().alert();
				String POPEX = POPUP.getText();
				elib.writedatafromExcel("sheet3", 5, 1, POPEX);
	            POPUP.accept();
	            ibhp.logout();
				
				
	}

}
