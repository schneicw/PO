package dev.schneider.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() {
			
			try {
				Properties props = new Properties();
				FileInputStream in = new FileInputStream("src/main/resources/connection.properties");
				props.load(in);
				String details = props.getProperty("conndetails");
				
				//Connection conn = DriverManager.getConnection("jdbc:mariadb://revtraindb.cobrwpnkiowc.us-west-1.rds.amazonaws.com:3306/SchoolDB?user=schneicw&password=dbpass123");
				Connection conn = DriverManager.getConnection(details);
				System.out.println(conn);
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
	}
	
	public static void main(String[] args) {
		getConnection();
	}
}
