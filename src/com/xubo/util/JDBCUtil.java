package com.xubo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	// 获取数据库连接
	public static Connection getConnection(String conType) {
		Connection con = null;
		try {
			Properties properties = new Properties();
			InputStream in = JDBCUtil.class.getResourceAsStream(conType+"jdbc.properties");
			properties.load(in);
			String url = (String)properties.get("jdbc.url");
			String drivenName = (String)properties.get("jdbc.drivenName");
			String username = (String)properties.get("jdbc.username");
			String password = (String)properties.get("jdbc.password");
			Class.forName(drivenName);
			con = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) rs.close(); 
			 if(stmt!=null) stmt.close();
			 if(con!=null)con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
