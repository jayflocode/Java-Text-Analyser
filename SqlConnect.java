package com.example.projectfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


         public class SqlConnect extends Main  {
        	 
        	 //array master stores current query information
        	 
        	public static ArrayList<String> arrayMaster;
        	
        	// public static string value for the name of the table
        	public static String schemaName = "";
        	//public static String query = "SELECT Words FROM word ORDER BY Words*1;";

			 public static String query = "";
        	
        	
        	//unused methods or setters for future use 
        	
        	
        	//sets query
        	

	        
	        
        	 
        	 //aids in printing columns for SQL queries

	       private static String pad(String s) {
		
		   int COLUMN_WIDTH = 25;
		   
			int padCount = COLUMN_WIDTH - s.length(); 
			
			StringBuilder sb = new StringBuilder(25);

			sb.append(s);
			
			for (int i = 0; i < padCount; i++) {
			sb.append(" "); }
			
			
			
			return sb.toString(); 
			}
	       
	       
	       
	       public static void print() throws Exception {
	    	   
	    	   //clears array so it doesn't stack queries with the same information
	    	   
	    	   
	    	   ArrayList<String> dbarray = new ArrayList<String>();
	    	   
	    	   
	    	   
	    	   Connection con = sql();
	    	   System.out.println("Select Query established"); 
	    	   System.out.println();
	    	   
	    	   Statement statement = con.createStatement();
	    	   
	    	   //query orders varchar information by numbers
	    	   
	    	   
	    	   
	    	  
	    	   
	    	   try {
				ResultSet resultSet = statement.executeQuery(query);
				   

				   StringBuilder sb = new StringBuilder();
				   
				   String st = "";
				   
				   ResultSetMetaData metaData = resultSet.getMetaData();
				    int columnCount = metaData.getColumnCount(); for (int i = 0; i < columnCount; i++) {
				    
				    System.out.print(pad(metaData.getColumnName(i + 1)));
				    
				    //adds column to array as first element
				    
				    
				    st = pad(metaData.getColumnName(i + 1));
				   
				    
				    st = sb.append(st).toString();
				    
				    
				    
				    }
				    
				    dbarray.add(st);
				    
				    
				    System.out.println();
				    System.out.println();
				    
				    //adds multiple lines to array
				    
				    dbarray.add("");
				    
				    StringBuilder info = new StringBuilder();
				    String in = "";
				    
				       while (resultSet.next()) {
				    	   
				    	StringBuilder builder = new StringBuilder();
				           
				        String string = "";   
				    	   
				    	   
				    	String[] row = new String[columnCount]; 
				    	
				    	
				    	for (int i = 0; i < columnCount; i++) {
				    	
				    	row[i] = resultSet.getString(i + 1);
				    	
				    	// adds row to array
				    	
				    	           	
				    
				    	
				         System.out.print(pad(row[i])); 
				      
				         
				         in = pad(row[i]);
				         in = builder.append(in).toString();
				         
				        
				        
				    	
				    	
				    	}
				    	
				    	 dbarray.add(in);
				    	
				    	
				    	
				    	
				    	System.out.println(); 
				    	
				    
				       
				       }
				    
				    
				System.out.println();
				
  
				
				
				arrayMaster = dbarray;
				
				for (int i = 0; i < arrayMaster.size(); i++) {
					
					System.out.println(arrayMaster.get(i));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
				System.out.println("There is an issue with the formatting of your query, try again");
				System.out.println();
				
				
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
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/" + schemaName;
		String username = "root";
		String password = "Jayroot84";
		
		Class.forName(driver);
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		System.out.println("Connected to database");
		
		return conn;
		
		} catch (Exception e) 
		{
			System.out.println("Error in connection try again");
		}
		
	
		return null;    
	
	}
	

}
