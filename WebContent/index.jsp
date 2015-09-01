<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>获取OpenId测试页</title>
</head>
<body>

<% 

String code = request.getParameter("code"); 
response.sendRedirect("test.html"); 



%>
</body>
</html>