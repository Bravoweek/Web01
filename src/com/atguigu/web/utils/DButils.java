package com.atguigu.web.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DButils {
	private static String user;
	private static String password;
	private static String jdbcUrl;
	private static String driverClass;
	private static Properties props;
   private static  ThreadLocal<Connection> connThreadlocal;
	
   static {
 InputStream is = DButils.class.getClassLoader().getResourceAsStream("db.properties");
 props = new Properties();
 
 try {
	props.load(is);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 user =props.getProperty("user");
 password =props.getProperty("password");
 jdbcUrl =props.getProperty("jdbcUrl");
 driverClass =props.getProperty("driverClass");
 
 connThreadlocal=new ThreadLocal<>();
 try {
	Class.forName(driverClass);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   }
	public static Connection  getConn() throws SQLException {
	   //从当前线程的THreadlocal本地变量中获取Connection
	Connection conn = connThreadlocal.get();
	if (conn==null) {
		//实例化一个Connection,保存到ThreadLocal
		conn = DriverManager.getConnection(jdbcUrl, user, password);
		connThreadlocal.set(conn);
	}
	return conn;
}
   public static  void closeConn() throws SQLException {
	   Connection conn = connThreadlocal.get();
	   if (conn!=null) {
		conn.close();
	}
}
	
}
