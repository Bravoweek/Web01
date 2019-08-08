package com.atguigu.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.web.utils.User;
import com.atguigu.web.utils.UserDao;
import com.atguigu.web.utils.UserDaoImpl;

public class LoginServlet extends HttpServlet {
	private UserDao userDao;
	
	public LoginServlet() {
		userDao=new UserDaoImpl();
	}

//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决post请求乱码
		request.setCharacterEncoding("utf-8");
		
		// 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+":"+password);
		
		// 参数校验
		if (username.equals("")|| password.equals("") ){
			return;
		} 
		// 必须在调用getWriter之前声明
		response.setContentType("text/html;charset=UTF-8");
		
		// 默认使用的ISO-8859-1编码
		PrintWriter writer = response.getWriter();
		
		// 连接数据库验证用户名和密码是否合法
		//User user;
		try {
			User user = userDao.findUserByUserNameAndPassword(username, password);
			if (user==null) {
				// 让用户来到index.jsp页面，且可以有一个错误消息的提示
				request.setAttribute("error", "用户名或密码错误！");
				// 转发：客户端在发第一次请求时，被服务器处理，当前处理的servlet没有完成 
				//处理，将请求和响应继续转发到下一个servlet继续处理,由最终环节的servlet处理完后响应。
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				//System.out.println("用户名和密码正确！");
				writer.print(true);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	System.out.println("处理了当前请求！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}







