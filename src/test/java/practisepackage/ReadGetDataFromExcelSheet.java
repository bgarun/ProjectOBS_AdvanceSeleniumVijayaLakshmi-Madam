package practisepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadGetDataFromExcelSheet {

	public static void main(String[] args) throws Throwable, Throwable {
		
	    //create object for physical path
		FileInputStream fi=new FileInputStream("./src/test/resources/Excel.xlsx");
		
		//create Workbook
		Workbook wb=WorkbookFactory.create(fi);
        
		//create sheet
		Sheet s = wb.getSheet("sheet1");
		
		//create Row
		Row rw = s.getRow(1);
		
		//Create cell
		Cell ce = rw.getCell(2);
		String Get = ce.getStringCellValue();
		//System.out.println(Get);
		
	    //ce.setCellValue("Kannada");
	    //System.out.println(ce);
	    
	    for(int i=1;i<=4;i++)
	    {
	    	String res = wb.getSheet("Sheet1").getRow(i).getCell(2).getStringCellValue();
	    System.out.println(res);
	    }
		
		
		//FileOutputStream fos=new FileOutputStream("./src/test/resources/Excel.xlsx");
		//wb.write(fos);
	}

}
