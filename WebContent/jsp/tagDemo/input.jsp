<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用自定义标签现实登陆</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/LoginServlet" method="post">
		用户名：<input type="text" name="uname"><br/>
		密码：<input type="password" name="upwd"><br/>
		<button class="btn btn-primary btn-sm" type="submit">登陆</button>
	</form>
</body>
</html>