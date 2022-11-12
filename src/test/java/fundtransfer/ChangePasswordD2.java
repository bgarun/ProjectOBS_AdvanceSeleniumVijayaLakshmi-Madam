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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class ChangePasswordD2 {

	public static void main(String[] args) throws Throwable {
		
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib= new Webdriver_Utilities();
		
		String BROWSER=flib.getDataFromPropertyFile("browser");
		String URL=flib.getDataFromPropertyFile("url");
		String UNS=flib.getDataFromPropertyFile("unstaff");
		String PWDS=flib.getDataFromPropertyFile("pwdstaff");
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
		
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		wlib.scrollBarAction(driver);
		driver.findElement(By.name("customer_id")).sendKeys(UNC);
		driver.findElement(By.name("password")).sendKeys(PWDC);
		driver.findElement(By.name("login-btn")).click();
		driver.findElement(By.xpath("//li[text()='Change Password']")).click();
		driver.findElement(By.name("oldpass")).sendKeys(PWDC);
		driver.findElement(By.name("cnfrm")).sendKeys(PWDC);
		driver.findElement(By.name("newpass")).sendKeys(UPWDC);
		driver.findElement(By.name("change_pass")).click();
		Alert CPWD = driver.switchTo().alert();
		String PRINT = CPWD.getText();
		elib.writedatafromExcel("sheet1", 14, 0, PRINT);
		CPWD.accept();
		driver.findElement(By.name("logout_btn")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		wlib.scrollBarAction(driver);
		driver.findElement(By.name("customer_id")).sendKeys(UNC);
		driver.findElement(By.name("password")).sendKeys(UPWDC);
		driver.findElement(By.name("login-btn")).click();
	}

}
