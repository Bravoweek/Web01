package com.atguigu.web.utils;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {
	User findUserByUserNameAndPassword(String username,String password) throws IOException, SQLException;
}
