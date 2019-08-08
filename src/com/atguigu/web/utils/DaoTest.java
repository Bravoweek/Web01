package com.atguigu.web.utils;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class DaoTest {

	@Test
	public void test() throws SQLException {
 
	User user = new UserDaoImpl().findUserByUserNameAndPassword("jack", "123123");
	
	System.out.println(user);
	}

}
