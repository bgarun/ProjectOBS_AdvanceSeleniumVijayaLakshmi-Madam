package practisepackage;

import org.testng.annotations.Test;

public class Sample2 {

	@Test(groups ={"smoke","regression"})
	public void script3()
	{
		System.out.println("Script333333333333");
	}
	
	@Test(groups="regression")
	public void script4()
	{
		System.out.println("Script4444444444444");
	}
	
	@Test
	public void Scriptc()
	{
		System.out.println("Scriptcccccccccccccc");
	}
}
