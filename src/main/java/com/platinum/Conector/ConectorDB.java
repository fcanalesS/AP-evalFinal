package com.platinum.Conector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConectorDB {
	 /*private static Connection connection = null;
	    
	    public static Connection getConnection() {
	        if (connection != null) {
	            return connection;
	        } else {
	            try {

	            	String dbUrl = "jdbc:mariadb://localhost:3306/cuentacorriente";
	                String dbUser = "fcanales";
	                String dbPassword = "felipe123";
	                Class.forName("org.mariadb.jdbc.Driver");
	                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            return connection;
	        }
	    }*/
	
	private static BasicDataSource ds = new BasicDataSource();
	
	static {
		ds.setUrl("jdbc:mariadb://localhost:3306/cuentacorriente");
		ds.setUsername("fcanales");
        ds.setPassword("felipe123");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
	}
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds.getConnection();
	}
	
	private void DBCPDataSource() {}
}
