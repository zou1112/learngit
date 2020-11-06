<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <style type="text/css">
  	#main{
  		position: absolute;
  		left: 600px;
  		top: 100px;
  	}
  	a:LINK {
  	
	text-decoration: none;
}
	p{
		text-indent:2em;
	}
  	
  </style>
</head>
<body style="background-color: #f2f2f2">
	<div id="main">
			<h1 style="color: #2F4056" href="">APP信息管理系统</h1>
			<p><a style="color: #2F4056" href="">后台管理系统入口</a></p>
			<p><a style="color: #2F4056" href="${basePath}/AppInfoSystem/login/Login">开发者平台入口</a></p>
	</div>
</body>
</html>