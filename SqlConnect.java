package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class SqlConnect extends Main  {
	
	      //truncates the database
	
	
      public static void truncate() throws Exception {
		
		final String var1 = "TRUNCATE `word occurrences`.`word`;";
		
		try {
		Connection con = sql();
		// INSERT INTO word VALUE ('Cardinal');
		
		
		PreparedStatement posted = con.prepareStatement(var1);
		
		posted.executeUpdate();
		
		}
		
		catch (Exception e)  {
			
			System.out.println(e);
		}
		
		finally {
			
			System.out.println("Database has been truncated");
		}
		
		
	}
	
      //inserts into the database 
	
	
	public static void insert(String entry) throws Exception {
		
		final String var1 = entry;
		
		try {
		Connection con = sql();
		// INSERT INTO word VALUE ('Cardinal');
		
		
		PreparedStatement posted = con.prepareStatement("INSERT INTO word VALUE ('" + var1 + "');" + "");
		
		posted.executeUpdate();
		
		}
		
		catch (Exception e)  {
			
			System.out.println(e);
		}
		
		finally {
			
			System.out.println("Update to Insert to SQL table completed");
		}
		
		
		
	//establishes a connection to the database	
	}
	
	public static  Connection sql() throws Exception {
		
		
		try {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/word occurrences";
		String username = "root";
		String password = "Jayroot84";
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		System.out.print("Connected to database");
		
		return conn;
		
		} catch (Exception e) 
		{
			System.out.println("Error in connection try again");
		}
		
	
		return null;    
	
	}
	

}
