<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/jsp/common/common.jsp" %>
<meta charset="UTF-8">
<title>注册信息</title>
</head>
<body style="background-color: green">
	<form method="post" action="<%=request.getContextPath() %>/registerServlet">
		用&nbsp;&nbsp;&nbsp;&nbsp;户：<input type="text" name="username" style="margin-top: 20px;"><br/>
		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd" style="margin-top: 20px;"><br/>
		<div style="margin: 30px;">
			<button type="submit" class="btn btn-primary btn-sm" style="margin-left: 20px;">确定</button>
			<button type="button" class="btn btn-primary btn-sm" style="margin-left: 30px;" onclick="oncancl()">取消</button>
		</div>
	</form>
	<script type="text/javascript">
		// 返回登陆页面
		function oncancl(){
			window.history.back(-1);
		}
	</script>
</body>
</html>