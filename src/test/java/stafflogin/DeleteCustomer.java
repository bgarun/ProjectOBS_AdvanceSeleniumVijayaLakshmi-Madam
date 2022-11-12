package stafflogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCustomer {

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
		String CSID = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String RM = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.name("staff_id")).sendKeys(US);
		driver.findElement(By.name("password")).sendKeys(PS);
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("del_cust")).click();
		driver.findElement(By.name("Cust_ac_no")).sendKeys(CUSACCNO);
		driver.findElement(By.name("Cust_ac_Id")).sendKeys(CSID);
		driver.findElement(By.name("reason")).sendKeys(RM);
		driver.findElement(By.name("delete")).click();
		driver.findElement(By.name("logout_btn")).click();
	}

}
