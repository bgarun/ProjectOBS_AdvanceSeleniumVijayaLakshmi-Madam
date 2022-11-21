package com.onlinebankingsystem.Banking.genericlibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Java_Utilities {
	/**
	 * This method is used to get random number
	 * @author Admin
	 * @return
	 */

	public int getRandomNumber()
	{
		Random ran=new Random();
		int random = ran.nextInt(10000);
		return random;
	}
	/**
	 * This method is used to get system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date date=new Date();
		String systemdate = date.toString();
		return systemdate;
	    
	}
	/**
	 * This method is used to get the date format as we required
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");
		Date systemDate=new Date();
		String getDateAndTime = dateFormat.format(systemDate);
		System.out.println(getDateAndTime);
		return  getDateAndTime.replaceAll(":", "-");
	}
}
