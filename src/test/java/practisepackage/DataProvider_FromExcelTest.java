package practisepackage;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;

public class DataProvider_FromExcelTest {

	public class DataProvideTest {
		   @Test(dataProvider="getdata")
		   public void travelling(String src,String dst,String hero)
		   {
			 
			   System.out.println(src+"----------->"+dst+"-->"+hero);
		   }
			
			@DataProvider
				public Object[][] getdata() throws Throwable, IOException 
				{
				Excel_Utilities elib=new Excel_Utilities();
				
				Object[][]	value=elib.readMultipledata("datasheet");
				return value;
				
				
			}
		}
}
