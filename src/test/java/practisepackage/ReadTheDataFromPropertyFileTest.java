package practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadTheDataFromPropertyFileTest {

	public static void main(String[] args) throws Throwable {
	//step1:-get java representation\src\test\resources\commondata.properties
     FileInputStream fis=new FileInputStream("./src/test/resources/commomdata.properties");
     
     //create object for properties class
     Properties p=new Properties();
     
     //load the keys
     p.load(fis);
     // get the value using string getproperty
     String Browser=p.getProperty("browser");
     String Url=p.getProperty("url");
     String Us=p.getProperty("unstaff");
     String Ps=p.getProperty("pwdstaff");
     System.out.println(Browser);
     System.out.println(Url);
     System.out.println(Us);
     System.out.println(Ps);
     
     WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		driver.findElement(By.name("staff_id")).sendKeys(Us);
		driver.findElement(By.name("password")).sendKeys(Ps);
     
     
     
	}

}
