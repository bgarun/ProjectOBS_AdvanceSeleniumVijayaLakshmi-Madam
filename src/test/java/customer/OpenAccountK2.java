package customer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.Select;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class OpenAccountK2 {

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib= new Webdriver_Utilities();
		
		String BROWSER = flib.getDataFromPropertyFile("browser");
		String URL = flib.getDataFromPropertyFile("url");
		String UNS = flib.getDataFromPropertyFile("unstaff");
		String PWDS = flib.getDataFromPropertyFile("pwdstaff");
		elib.getLastRowNo("sheet7");
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
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		wlib.scrollBarAction(driver);
		elib.getListByName("sheet7", driver);
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
		WebElement DD1 = driver.findElement(By.name("state"));
		wlib.select("Washington", DD1);
		WebElement DD2 = driver.findElement(By.name("city"));
		wlib.select("Los Angeles", DD2);
		WebElement DD3 = driver.findElement(By.name("acctype"));
		
		wlib.select("Saving", DD3);
		WebElement DD = driver.findElement(By.name("gender"));
		wlib.select("Male", DD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//input[contains(@class,'cnfrm-submit-btn')]/following-sibling::input")).click();
		driver.findElement(By.name("submit")).click();
		wlib.scrollBarAction(driver);
		driver.findElement(By.name("cnfrm-submit")).click();
		Alert APPNO = driver.switchTo().alert();
		String APNO = APPNO.getText();
	    elib.writedatafromExcel("sheet7", 11, 1, APNO);
		APPNO.accept();
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.name("staff_id")).sendKeys(UNS);
		driver.findElement(By.name("password")).sendKeys(PWDS);
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("apprvac")).click();
		String APPNO1 = elib.readdatafromExcel("sheet8", 0, 1);
		driver.findElement(By.name("application_no")).sendKeys(APPNO1);
		driver.findElement(By.name("search_application")).click();
		wlib.scrollBarAction(driver);
		driver.findElement(By.name("approve_cust")).click();
		Alert REF = driver.switchTo().alert();
		String REFEX = REF.getText();
		elib.writedatafromExcel("sheet8", 4, 1, REFEX);
		REF.accept();
		driver.findElement(By.xpath("//input[@value='Logout']")).click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
      
		

	}

}
