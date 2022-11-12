package com.onlinebankingsystem.Banking.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utilities {
	
	/**
	 * This method is used to read data from property file
	 * @author Admin
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(Ipath_Constants.FilePath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	
	
	
	

	
}
