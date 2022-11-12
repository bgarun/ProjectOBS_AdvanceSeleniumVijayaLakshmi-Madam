package fundtransfer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class FundTransfer_AddBeneficiaryD1 {

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
				
				
			
		String BNAME=elib.readdatafromExcel("sheet2", 14, 1);
		String BACCNO=elib.readdatafromExcel("sheet2", 15, 1);
		String IFSC=elib.readdatafromExcel("sheet2", 16, 1);
		String AMT=elib.readdatafromExcel("sheet2", 17, 1);
		String RMS=elib.readdatafromExcel("sheet2", 18, 1);
			
				
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
				driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				
				wlib.scrollBarAction(driver);
				driver.findElement(By.name("customer_id")).sendKeys(UNC);
				driver.findElement(By.name("password")).sendKeys(PWDC);
				driver.findElement(By.name("login-btn")).click();
		
				driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				driver.findElement(By.name("add_beneficiary")).click();
				
				wlib.scrollBarAction(driver);
				driver.findElement(By.name("beneficiary_name")).sendKeys(BNAME);
				driver.findElement(By.name("beneficiary_acno")).sendKeys(BACCNO);
				driver.findElement(By.name("Ifsc_code")).sendKeys(IFSC);
				WebElement DD = driver.findElement(By.name("beneficiary_acc_type"));
				
				wlib.select("Saving", DD);
				driver.findElement(By.name("add_beneficiary_btn")).click();
				Alert ADD = driver.switchTo().alert();
				String TE = ADD.getText();
				elib.writedatafromExcel("sheet2", 21, 2, TE);
				ADD.accept();
				
                driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				
                wlib.scrollBarAction(driver);
				WebElement DD1 = driver.findElement(By.name("beneficiary"));
				wlib.select("1011131011885", DD1);
				driver.findElement(By.name("trnsf_amount")).sendKeys(AMT);
				Thread.sleep(7000);
				driver.findElement(By.name("trnsf_remark")).sendKeys(RMS);
				driver.findElement(By.name("fnd_trns_btn")).click();
				Thread.sleep(15000);//OTP ENTERING
				driver.findElement(By.name("verify-btn")).click();
				Alert POPUP = driver.switchTo().alert();
				String POPEX = POPUP.getText();
				elib.writedatafromExcel("sheet2", 22, 2, POPEX);
	            POPUP.accept();
				driver.findElement(By.name("logout_btn")).click();
				
	}

}
