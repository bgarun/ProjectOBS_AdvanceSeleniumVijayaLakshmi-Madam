package practisepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSetDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {

	    //create object for physical path
		FileInputStream fi=new FileInputStream("./src/test/resources/Excel.xlsx");
		
		//create Workbook
		Workbook wb=WorkbookFactory.create(fi);
        
		//create sheet
		Sheet s = wb.getSheet("sheet1");
		
		//create Row
		Row rw = s.createRow(4);
		
		//Create cell
		Cell ce = rw.createCell(2);
		ce.setCellValue("tamilnadu");
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Excel.xlsx");
             wb.write(fos);
             
	}

}
