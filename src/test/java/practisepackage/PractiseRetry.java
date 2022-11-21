package practisepackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PractiseRetry {

	@Test(retryAnalyzer=com.onlinebankingsystem.Banking.genericlibrary.RetryImplementationClass.class)
	
	public void retry()
	{
		System.out.println("----Script1-----");
		System.out.println("----Script2-----");

		System.out.println("----Script3-----");
		Assert.fail();
		System.out.println("----Script4-----");
		System.out.println("----Script5-----");
	}
}
