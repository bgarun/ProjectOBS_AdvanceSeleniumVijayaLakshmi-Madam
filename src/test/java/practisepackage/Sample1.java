package practisepackage;

import org.testng.annotations.Test;

public class Sample1 {

	@Test(groups = {"smoke","regression"})
	public void script1()
	{
		System.out.println("Script1111111111");
	}
	
	@Test(groups="regression")
	public void script2()
	{
		System.out.println("Script22222222222");
	}
	
	@Test
	public void Scriptd()
	{
		System.out.println("Scriptdddddddddddd");
	}
}
