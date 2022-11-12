package practisepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException {
		Driver driver=new Driver();
		// Register the database
		DriverManager.registerDriver(driver);
		// get Connection for database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
		// issue create statement
		Statement st=con.createStatement();
		String query="select * from client_info";
		//execute query
	       ResultSet result = st.executeQuery(query);
	       while(result.next())
	       {
	    	   System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
	       }
		//close the database connection
        con.close();
	}

}
