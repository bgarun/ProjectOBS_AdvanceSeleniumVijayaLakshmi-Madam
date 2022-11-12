package practisepackage;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
//Hard Assert
	/*@Test
	
	public void create()
	{
		System.out.println("------Line1--------");
		System.out.println("------Line2--------");
		System.out.println("------Line3--------");
	     Assert.assertEquals("A", "B");
		System.out.println("------Line4--------");
		System.out.println("------Line5--------");
	}
	
	
	@Test
	
	public void update()
	{
		System.out.println("------Line6--------");
		System.out.println("------Line7--------");
		System.out.println("------Line8--------");
	     Assert.assertNotEquals("A", "B");
		System.out.println("------Line9--------");
		System.out.println("------Line0--------");
	}*/
	
	// SoftAssert
 /*  @Test
	
	public void delete()
	{
		System.out.println("------LineA--------");
		System.out.println("------LineB--------");
		System.out.println("------LineC--------");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("A", "B");
		System.out.println("------LineD--------");
		System.out.println("------LineE--------");
		//sa.assertAll();
		sa.fail();
	}

@Test

public void confirm()
{
	System.out.println("------LineF--------");
	System.out.println("------LineG--------");
	System.out.println("------LineH--------");
	SoftAssert sa=new SoftAssert();
	sa.assertNotEquals("A", "B");
	System.out.println("------LineI--------");
	System.out.println("------LineJ--------");
	//sa.assertAll();
}
*/
@Test

public void open()
{
	String a="testyantra";
	String b="qspiders";
	System.out.println("------LineFfff--------");
	System.out.println("------LineGgggg--------");
	System.out.println("------LineHhhhh--------");
	assertTrue(a.equals(b));
	//sa.assertNotEquals("A", "B");
	System.out.println("------LineIiiii--------");
	System.out.println("------LineJjjjj--------");
	//sa.assertAll();
}

@Test

public void close()
{
	String x=null;
	assertNull(x);
	System.out.println("------LineF1111111--------");
	System.out.println("------LineG2222222222--------");
	System.out.println("------LineH3333333--------");
	//assertTrue(a.equals(b));
	//sa.assertNotEquals("A", "B");
	System.out.println("------LineI4444444--------");
	System.out.println("------LineJ555555--------");
	//sa.assertAll();
}

}
