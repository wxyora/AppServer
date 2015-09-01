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
response.sendRedirect("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx458a41033e38238c&secret=a3fbaed5c3c174afdb5a6e6f9e7396e2&code="+code+"&grant_type=authorization_code"); 



%>
</body>
</html>