package stafflogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.File_Utilities;
import com.onlinebankingsystem.Banking.genericlibrary.Webdriver_Utilities;

public class ViewActiveCustomerK1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//data driven testing  property file
		//FileInputStream fis=new FileInputStream("./src/test/resources/commomdata.properties");
		//Properties p=new Properties();
		//p.load(fis);
		File_Utilities flib=new File_Utilities();
		Excel_Utilities elib=new Excel_Utilities();
		Webdriver_Utilities wlib=new Webdriver_Utilities();
		String BROWSER = flib.getDataFromPropertyFile("browser");
		String URL=flib.getDataFromPropertyFile("url");
		String UNS=flib.getDataFromPropertyFile("unstaff");
		String PWDS=flib.getDataFromPropertyFile("pwdstaff");
		String ACCNO=elib.readdatafromExcel("sheet1", 9, 1);
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
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
	
		driver.findElement(By.name("staff_id")).sendKeys(UNS);
		driver.findElement(By.name("password")).sendKeys(PWDS);
		driver.findElement(By.name("staff_login-btn")).click();
        driver.findElement(By.name("viewdet")).click();
        driver.findElement(By.name("home")).click();
        driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
        driver.findElement(By.name("apprvac")).click();
        driver.findElement(By.name("application_no")).sendKeys(ACCNO);
        driver.findElement(By.name("search_application")).click();
        wlib.scrollBarAction(driver);
        driver.findElement(By.name("approve_cust")).click();
        Alert POPUP = driver.switchTo().alert();
         String PRINT = POPUP.getText();
          elib.writedatafromExcel("sheet1", 10, 1, PRINT);
          POPUP.accept();
        driver.findElement(By.name("logout_btn")).click();
        driver.findElement(By.xpath("//a[text()='Home']")).click();
	}

}
