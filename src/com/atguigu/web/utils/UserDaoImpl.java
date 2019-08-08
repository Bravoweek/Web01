package com.atguigu.web.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByUserNameAndPassword(String username,String password) throws SQLException {
         
		User user=null;
		
		Connection conn = DButils.getConn();
         String sql ="select * from tbl_user where username=? and password=?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, username);
         ps.setString(2, password);
         
         ResultSet rs = ps.executeQuery();
         while (rs.next()) {
			user = new User();
			user.setId(rs.getInt("id") );
           user.setName(rs.getString("password"));	
           user.setPassword(rs.getString("password"));
		}
         
		return user;
	}

}
