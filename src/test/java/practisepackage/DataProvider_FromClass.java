package practisepackage;

import org.testng.annotations.Test;

public class DataProvider_FromClass {

			   @Test(dataProviderClass=DataPdrClass.class, dataProvider="readMultipledata")
			   public void travelling(String name,String price)
			   {
				 
				   System.out.println(name+"----------->"+price);
			   }
				
				/*@DataProvider
					public Object[][] getdata() throws Throwable, IOException 
					{
					Excel_Utilities elib=new Excel_Utilities();
					
					Object[][]	value=elib.readMultipledata("readmultipledata");
					return value;*/
					
					
				
			}

