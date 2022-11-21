package testcasestestng;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.onlinebankingsystem.Banking.genericlibrary.BaseClass;

import in.onlinebankingsystem.banking.objectrepository.AddBeneficiaryPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferLoginPage;
import in.onlinebankingsystem.banking.objectrepository.FundTransferPage;
import in.onlinebankingsystem.banking.objectrepository.HomePage;
import in.onlinebankingsystem.banking.objectrepository.InternetBankingHomePage;
import in.onlinebankingsystem.banking.objectrepository.OtpConfirmationPage;


//@Listeners(com.onlinebankingsystem.Banking.genericlibrary.ListenersImplementation.class)
public class Test2Test extends BaseClass{
	
	@Test(groups = "smoke")
	public void addBeneficiaryTransferFund() throws IOException, InterruptedException{
		

		String UNC=flib.getDataFromPropertyFile("uncustomer");
		String PWDC=flib.getDataFromPropertyFile("pwdcustomer");		
			
		String BNAME=elib.readdatafromExcel("sheet2", 0, 1);
		String BACCNO=elib.readdatafromExcel("sheet2", 1, 1);
		String IFSC=elib.readdatafromExcel("sheet2", 2, 1);
		String AMT=elib.readdatafromExcel("sheet1", 1, 1);
		String RMS=elib.readdatafromExcel("sheet1", 2, 1);
		String ACCTYPE=elib.readdatafromExcel("sheet2", 3, 1);
		String SELBEN=elib.readdatafromExcel("sheet1", 0, 1);
			
				
				wlib.waitForPageLoad(driver);
			
				HomePage hp=new HomePage(driver);
				hp.fundtransfer();
				
				FundTransferLoginPage ftlp=new FundTransferLoginPage(driver);
				ftlp.customerid(UNC, PWDC);
		        InternetBankingHomePage ibhp=new InternetBankingHomePage(driver);
		        ibhp.fundtransfer();
		        FundTransferPage ftp=new FundTransferPage(driver);
		        ftp.addbeneficiary();
		       
		        
			
				AddBeneficiaryPage abp=new AddBeneficiaryPage(driver);
				abp.beneficiaryname(BNAME, BACCNO, IFSC);
				abp.acctypedropdown(ACCTYPE);
			
				Alert ADD = driver.switchTo().alert();
				String TE = ADD.getText();
				elib.writedatafromExcel("sheet3", 41, 5, TE);
				ADD.accept();
				
				abp.fundtransfer();
                wlib.scrollBarAction(driver);
                ftp.selectbeneficiary(SELBEN, AMT, RMS);
				Thread.sleep(15000);//OTP ENTERING
				OtpConfirmationPage ocp=new OtpConfirmationPage(driver);
				ocp.verifybutton();
				 
				
			  
				
				Alert POPUP = driver.switchTo().alert();
				String POPEX = POPUP.getText();
				elib.writedatafromExcel("sheet3", 42, 5, POPEX);
	            POPUP.accept();
	           
	            ibhp.logout();
	}
}
