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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FundTransfer_SendMoney {

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
				String AMT = wb.getSheet("Sheet2").getRow(1).getCell(3).getStringCellValue();
				String RMS = wb.getSheet("Sheet2").getRow(1).getCell(4).getStringCellValue();
				
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
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,700)");
				driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				js.executeScript("window.scrollBy(0,700)");
				driver.findElement(By.name("customer_id")).sendKeys(UC);
				driver.findElement(By.name("password")).sendKeys(PC);
				driver.findElement(By.name("login-btn")).click();
				
				driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
				js.executeScript("window.scrollBy(0,400)");
				WebElement DD = driver.findElement(By.name("beneficiary"));
				Select s=new Select(DD);
				s.selectByValue("1011731011535");
				driver.findElement(By.name("trnsf_amount")).sendKeys(AMT);
				driver.findElement(By.name("trnsf_remark")).sendKeys(RMS);
				driver.findElement(By.name("fnd_trns_btn")).click();
				//WebElement OTP = driver.findElement(By.xpath("//label[contains(@class,'OTP')]"));
				driver.findElement(By.name("otpcode")).sendKeys("O");
				Thread.sleep(15000);
				driver.findElement(By.name("verify-btn")).click();
				driver.switchTo().alert().accept();
				driver.findElement(By.name("logout_btn")).click();
				
				
				
				
	}

}
