package practisepackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Check {

	@Test(invocationCount = -1)
	public void ram()
	{
		System.out.println("ram");
		
	}
	
	@Test(priority = -1,invocationCount = 0)
	public void laxman()
	{
		System.out.println("laxman");
		
	}
	
	@Test(dependsOnMethods = "laxman")
	public void sita()
	{
		System.out.println("sita");
		
	}
	
	@Test(priority = -1)
	public void bhim()
	{
		System.out.println("bhim");
		
	}

}
