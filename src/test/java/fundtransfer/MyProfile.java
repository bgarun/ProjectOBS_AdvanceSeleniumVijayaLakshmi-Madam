package fundtransfer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class MyProfile {

	public static void main(String[] args) throws Throwable {
		//data driven testing  property file
				FileInputStream fis=new FileInputStream("./src/test/resources/commomdata.properties");
				Properties p=new Properties();
				p.load(fis);
				String BROWSER = p.getProperty("browser");
				String URL = p.getProperty("url");
				String US = p.getProperty("unstaff");
				String PS = p.getProperty("pwdstaff");
				String UC = p.getProperty("uncustomer");
				String PC = p.getProperty("pwdcustomer");
				String UPC = p.getProperty("updatepwd");
				
				//data driven testing Excel file
				FileInputStream fi=new FileInputStream("./src/test/resources/Excel.xlsx");
				Workbook wb=WorkbookFactory.create(fi);
				String APPNO = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
				
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
				Webdriver_Utilities wlib=new Webdriver_Utilities();
				wlib.waitForPageLoad(driver);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,700)");
				driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,700)");
				driver.findElement(By.name("customer_id")).sendKeys(UC);
				driver.findElement(By.name("password")).sendKeys(PC);
				driver.findElement(By.name("login-btn")).click();
				driver.findElement(By.xpath("//li[text()='My Profile']")).click();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,700)");
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,-700)");
				Thread.sleep(2000);
				driver.findElement(By.name("logout_btn")).click();

	}

}
