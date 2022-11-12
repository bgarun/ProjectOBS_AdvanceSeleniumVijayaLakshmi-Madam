package practisepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest1 {

	public static void main(String[] args) throws SQLException {
		int result=0;
		Driver driver=new Driver();
		//register for database
		DriverManager.registerDriver(driver);
		//get the connection with database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
        //issue create statement
		Statement st = con.createStatement();
		String query="insert into client_info values('Dinesh',9866986698,'hubli','Telugu')";
		//execute query
		result=st.executeUpdate(query);
		if(result==1)
		{
			System.out.println("database is updated");
		}
		else
		{
			System.err.println("Database is not updated");
		}
		//close the connection
		con.close();
	}

}
