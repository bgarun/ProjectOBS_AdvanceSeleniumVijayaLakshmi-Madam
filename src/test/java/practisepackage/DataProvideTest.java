package practisepackage;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.onlinebankingsystem.Banking.genericlibrary.Excel_Utilities;

public class DataProvideTest {
   @Test(dataProvider="getdata")
   public void travelling(String src,String dst,int fare)
   {
	   System.out.println(src+"-->"+dst+"-->"+fare);
	   
   }
	
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] obj=new Object[5][3];
		obj[0][0] ="Bangalore";
		obj[0][1]="Hubli";
		obj[0][2]=5000;
		
		obj[1][0] ="Hubli";
		obj[1][1]="Bangalore";
		obj[1][2]=6000;
		
		obj[2][0] ="Nellore";
		obj[2][1]="Hubli";
		obj[2][2]=1000;

		obj[3][0] ="Hubli";
		obj[3][1]="Nellore";
		obj[3][2]=5000;
		
		obj[4][0] ="Bangalore";
		obj[4][1]="Tirupathi";
		obj[4][2]=5000;
		return obj;
		
		
		
	}
}
