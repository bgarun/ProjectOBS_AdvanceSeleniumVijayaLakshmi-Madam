package practisepackage;

import org.testng.Assert;
import org.testng.TestRunner.PriorityWeight;
import org.testng.annotations.Test;

public class CreateCustomerTest {

	@Test(enabled=false)
	public void createCustomer()
	{
		System.out.println("customer is created sucessfully");
	}
	
	@Test(invocationCount = 1, priority = -1,enabled=true)
	public void updateCustomer()
	{
		int[] arr= {1,2,3};
		System.out.println("customer is updated sucessfully");
		System.out.println(arr[5]);
		//Assert.fail();
		//throw new ArithmeticException();
	}
	
	@Test(dependsOnMethods = "updateCustomer", invocationCount = 2, priority=1, enabled=true)
	public void deleteCustomer()
	{
		System.err.println("customer is deleted sucessfully");
	    Assert.fail();
	}
	
	@Test(invocationCount = 2,priority = 1)
	public void approveCustomer()
	{
		System.out.println("customer is approved sucessfully");
	}
	
	final static int count=2;
	@Test(priority = 2,invocationCount = count)
	public void fundTransfer()
	{
		System.out.println("fund transfered sucessfully");
	}
}
