package fundtransfer;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FundTransfer_DeleteBeneficiary {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.name("customer_id")).sendKeys(UC);
		driver.findElement(By.name("password")).sendKeys(PC);
		driver.findElement(By.name("login-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		driver.findElement(By.name("delete_beneficiary")).click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("delete_beneficiary")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		driver.findElement(By.name("logout_btn")).click();
	
		

	}

}
