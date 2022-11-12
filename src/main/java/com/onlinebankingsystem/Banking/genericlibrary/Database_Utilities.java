package com.onlinebankingsystem.Banking.genericlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Database_Utilities {
	/**
	 * This method is used to register and get the connection for the database
	 */
    Connection con=null;
	public void connectToDb() throws SQLException
	{
		Driver driver =new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(Ipath_Constants.Url, Ipath_Constants.DBUserName, Ipath_Constants.DBPassword);
		
	}
	/**
	 * This method is used to execute query and get the data for user
	 * @param query
	 * @param ColumnIndex
	 * @param expdata
	 * @param data
	 * @return 
	 * @return
	 * @throws SQLException 
	 * @throws Throwable
	 */
	

	public String executeQueryAndgetData(String query,int ColumnIndex,String expdata, String data) throws Throwable 
	{
       boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			 data = result.getString(ColumnIndex);
			if(data.equalsIgnoreCase(expdata));
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(data+"------->data verified");
			return expdata;
		}
		else
		{
			System.out.println(data+"-------> not verified");
			return "";
		}
		
	}
	/**
	 * This method is used to close the database
	 * @throws SQLException 
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
}
