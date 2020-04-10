<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="www.xubo.com" prefix="xb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="WelcomServlet" method="post">
		<input type="submit">
		<a href="WelcomServlet2">lianjie</a>
	</form>
	<xb:mytag num="3">hello<br/></xb:mytag>
	<xb:mytagupper><h2>hello</h2></xb:mytagupper>
	<xb:mysimpletag num="4"><h1>Hi</h1></xb:mysimpletag>
	<xb:mytagif flag="1==1"><h2>会输出</h2></xb:mytagif>
	<xb:mytagif flag="1==2"><h2>不会输出</h2></xb:mytagif>
</body>
</html>