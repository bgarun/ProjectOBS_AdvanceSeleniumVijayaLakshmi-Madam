package practisepackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.onlinebankingsystem.Banking.genericlibrary.Ipath_Constants;

public class DataPdrClass {

	@DataProvider
	public Object[][] readMultipledata() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("datasheet");
		
		int lastrow = sh.getLastRowNum()+1;
		int lastcell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				
				obj[i][j] =sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
}
