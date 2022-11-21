package stafflogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class CreditCustomer {

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
				String AMT = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(URL);
				Webdriver_Utilities wlib=new Webdriver_Utilities();
				wlib.waitForPageLoad(driver);
				driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("staff_id")).sendKeys(US);
				Thread.sleep(2000);
				driver.findElement(By.name("password")).sendKeys(PS);
				Thread.sleep(2000);
				driver.findElement(By.name("staff_login-btn")).click();
				driver.findElement(By.name("credit_cust_ac")).click();
				driver.findElement(By.name("customer_account_no")).sendKeys(CUSACCNO);
				driver.findElement(By.name("credit_amount")).sendKeys(AMT);
			    driver.findElement(By.name("credit_btn")).click();
				
				Thread.sleep(2000);
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
				driver.findElement(By.name("logout_btn")).click();
	}

}
