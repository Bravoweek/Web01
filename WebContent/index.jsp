<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
		<%-- <% String errorStr=(String)request.getAttribute("error"); %>
		<h1>欢迎登录</h1>
		<form action="/Javaweb_Day02/abc" method="post">
				用户名称：<input name="username" value=""/><span><%=errorStr==null?"":errorStr %></span><br>
				用户密码：<input name="password" value="123"/><br>
				<input type="submit" value="提交">
		</form> --%>
		
		<h1>欢迎登录</h1>
		<form action="/Javaweb_Day02/abc" method="post">
				用户名称：<input name="username" value=""/><span>${error }</span><br>
				用户密码：<input name="password" value="123"/><br>
				<input type="submit" value="提交">
		</form>

</body>
</html>