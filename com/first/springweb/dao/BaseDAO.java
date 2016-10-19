package com.first.springweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {

	private static Connection connection;
	
	static{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ran", "root", "Pwd4ROOT");
		} catch(Exception e){
			System.out.println("Connection failed.");
		}
	}
	public static Connection getConnection(){
		return connection;
	}
}
