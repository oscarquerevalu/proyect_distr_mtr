package com.skar.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnModel {
	
	 
	
	public Connection dbConnect()
	        {
	                try
	                {
	                		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EasyMuni;user=sa;password=sa2112");
	 
	                        System.out.println("connected");
	                        return conn;
	                         
	                }
	                catch (Exception e)
	                {
	                        e.printStackTrace();
	                        return null;
	                }
	        }
	 

}
