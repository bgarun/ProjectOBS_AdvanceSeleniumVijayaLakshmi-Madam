package com.onlinebankingsystem.Banking.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Excel_Utilities extends Java_Utilities{
	/**
	 * This method is used to read the data
	 * @author Admin
	 * @param sheetName
	 * @param rowNo
	 * @param coloumnNo
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String readdatafromExcel(String sheetName, int rowNo,int coloumnNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(sheetName);
		 Row ro = sh.getRow(rowNo);
		  Cell cel = ro.getCell(coloumnNo);
		  String value = cel.getStringCellValue();
		  return value;
					
	}
	
	/**
	 * This method is used to write the data
	 * @author Admin
	 * @param sheetName
	 * @param rowNo
	 * @param coloumnNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writedatafromExcel(String sheetName, int rowNo,int coloumnNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(sheetName);
		 Row ro = sh.createRow(rowNo);
		  Cell cel = ro.createCell(coloumnNo);
		  cel.setCellValue(data);
		  FileOutputStream fos=new FileOutputStream(Ipath_Constants.ExcelPath);
		  wb.write(fos);
		
	}
	/**
	 * This method is used to get last row count
	 * @author Admin
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet(sheetName);
		 int count= sh.getLastRowNum();
		 return count;
					
	}
	
	public void getListByName(String sheetname, WebDriver driver) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh= wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		for(int i=0; i<=count; i++)
		{
			String key= sh.getRow(i).getCell(0).getStringCellValue();
			String value= sh.getRow(i).getCell(1).getStringCellValue();
			 driver.findElement(By.name(key)).sendKeys(value);
              
		}
	}
	
	public void getListByXpath(String sheetname, WebDriver driver) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh= wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		for(int i=0; i<=count; i++)
		{
			String key= sh.getRow(i).getCell(0).getStringCellValue();
			String value= sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.xpath(key)).sendKeys(value);
			  
		}
	}
	
	public Map<String, String> getList(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh= wb.getSheet(sheetname);
		int count = sh.getLastRowNum();
		Map<String, String> map = new HashMap<String,String>();
		for(int i=0; i<=count; i++)
		{
			String key= sh.getRow(i).getCell(0).getStringCellValue();
			String value= sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
	
	public Object[][] readMultipledata(String sheetName) throws EncryptedDocumentException, IOException
	{

		FileInputStream fi=new FileInputStream(Ipath_Constants.ExcelPath);
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		
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
