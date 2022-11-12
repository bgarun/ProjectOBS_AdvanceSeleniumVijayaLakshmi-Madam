package practisepackage;

import org.testng.annotations.Test;

public class Sample4 {

	@Test(groups = {"smoke","regression"})
	public void Script7()
	{
		System.out.println("Script77777777777777777");
	}
	
	@Test(groups="regression")
	public void Script8()
	{
		System.out.println("Script8888888888888888");
	}
	
	@Test
	public void Scripta()
	{
		System.out.println("Scriptaaaaaaaaaaaaaaa");
	}
}
