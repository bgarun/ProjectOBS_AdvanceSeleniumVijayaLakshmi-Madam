package stafflogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class ViewCustomerByAccountNumber {

	public static void main(String[] args) throws Throwable {
		//data driven testing  property file
				FileInputStream fis=new FileInputStream("./src/test/resources/commomdata.properties");
				Properties p=new Properties();
				p.load(fis);
				String BROWSER = p.getProperty("browser");
				String URL = p.getProperty("url");
				String US = p.getProperty("unstaff");
				String PS = p.getProperty("pwdstaff");
				
				//data driven testing Excel file
				FileInputStream fi=new FileInputStream("./src/test/resources/Excel.xlsx");
				Workbook wb=WorkbookFactory.create(fi);
				String CUSACCNO = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
				
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
				Webdriver_Utilities wlib=new Webdriver_Utilities();
				wlib.waitForPageLoad(driver);
				driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
				
				driver.findElement(By.name("staff_id")).sendKeys(US);
				
				driver.findElement(By.name("password")).sendKeys(PS);
				
				driver.findElement(By.name("staff_login-btn")).click();
				
				driver.findElement(By.name("view_cust_by_ac")).click();
				
				driver.findElement(By.name("account_no")).sendKeys(CUSACCNO);
				Thread.sleep(2000);
				driver.findElement(By.name("submit_view")).click();
				Thread.sleep(2000);
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,700)");
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,-700)");
				Thread.sleep(2000);
				driver.findElement(By.name("logout_btn")).click();
				
				

	}

}
