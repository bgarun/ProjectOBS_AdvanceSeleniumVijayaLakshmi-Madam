package debitcard;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class ApplyDebitCardK3 {

	public static void main(String[] args) throws Throwable {
		
		Random ran=new Random();
		int random = ran.nextInt(10000);
		
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib= new Webdriver_Utilities();
		
				String BROWSER = flib.getDataFromPropertyFile("browser");
				String URL = flib.getDataFromPropertyFile("url");
				String UNS = flib.getDataFromPropertyFile("unstaff");
				String PWDS = flib.getDataFromPropertyFile("pwdstaff");
				String UNC = flib.getDataFromPropertyFile("uncustomer");
				String PWDC = flib.getDataFromPropertyFile("pwdcustomer");
				String UPWDC = flib.getDataFromPropertyFile("updatepwd");
				
				String BNAME = elib.readdatafromExcel("sheet5", 0, 1);
				String BACCNO = elib.readdatafromExcel("sheet5", 1, 1);
				String IFSC = elib.readdatafromExcel("sheet5", 2, 1);
				String AMT = elib.readdatafromExcel("sheet5", 3, 1);
				String RMS = elib.readdatafromExcel("sheet5", 4, 1);
				
				
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
				driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();
              
				elib.getListByName("sheet5", driver);
				
                driver.findElement(By.name("dob")).click();
              
                Robot r=new Robot();
                r.keyPress(KeyEvent.VK_0);
                r.keyRelease(KeyEvent.VK_0);
                r.keyPress(KeyEvent.VK_8);
                r.keyRelease(KeyEvent.VK_8);
                r.keyPress(KeyEvent.VK_2);
                r.keyRelease(KeyEvent.VK_2);
                r.keyPress(KeyEvent.VK_8);
                r.keyRelease(KeyEvent.VK_8);
                r.keyPress(KeyEvent.VK_1);
                r.keyRelease(KeyEvent.VK_1);
                r.keyPress(KeyEvent.VK_9); 
                r.keyRelease(KeyEvent.VK_9);
                r.keyPress(KeyEvent.VK_9);
                r.keyRelease(KeyEvent.VK_9);
                r.keyPress(KeyEvent.VK_3);
                r.keyRelease(KeyEvent.VK_3);
               
             
                
                driver.findElement(By.xpath("//input[@type='submit']")).submit();
                Alert DC = driver.switchTo().alert();
                String PRINT = DC.getText();
                elib.writedatafromExcel("sheet5", 6, 1, PRINT);
                DC.accept();
            
           
                driver.findElement(By.xpath("//a[text()='Home']")).click();
                wlib.scrollBarAction(driver);
               
        		WebElement REG = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
              
                wlib.mouseHover(driver, REG);
                driver.findElement(By.xpath("//li[text()='Login ']")).click();
                
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
				elib.writedatafromExcel("sheet5",8,1,TE);
				ADD.accept();
				
                driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
                wlib.scrollBarAction(driver);
				WebElement DD1 = driver.findElement(By.name("beneficiary"));
				wlib.select("1011131011885", DD1);
				driver.findElement(By.name("trnsf_amount")).sendKeys(AMT);
				driver.findElement(By.name("trnsf_remark")).sendKeys(RMS);
			     driver.findElement(By.name("fnd_trns_btn")).click();
			     Thread.sleep(15000);
			     driver.findElement(By.name("verify-btn")).click();
			     Alert POPUP = driver.switchTo().alert();
			     String PPOPUP = POPUP.getText();
			     elib.writedatafromExcel("sheet5", 9, 1, PPOPUP);
			     POPUP.accept();
				driver.findElement(By.xpath("//li[text()='My Account']")).click();
				wlib.scrollBarAction(driver);
				driver.findElement(By.name("logout_btn")).click();      
                
	}

	
	

}
