<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body style="background-image: url('<%=contextPath%>/img/logo.jpg');">
	<div>
		<form method="post" onsubmit="return check()">
			用&nbsp;&nbsp;&nbsp;&nbsp;户：<input type="text" name="username" id="username" style="margin-top: 20px;"><br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="pwd" id="pwd" style="margin-top: 20px;"><br/>
			验证码：<input type="text" name="code" id="code" style="margin-top: 20px;">
			<img src="../checkCode/img.jsp" style="margin-left: 10px;"><br/>
			<div style="margin: 30px;">
				<button type="button" class="btn btn-primary btn-sm" style="margin-left: 20px;" onclick="login()">登陆</button>
				<a href="register.jsp">
					<button type="button" class="btn btn-primary btn-sm" style="margin-left: 30px;">注册</button>
				</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function login(){
			if(check()){
				
			}
		}
		// 校验登陆信息
		function check(){
			var username = $("#username").val().trim();
			var pwd = $("#pwd").val().trim();
			var code = $("#code").val().trim();
			if(username == null || username == "" || pwd == null || pwd == "" || code == null || code == ""){
		　　　　alert("用户、密码、验证码不能为空！");
		　　　　return false;
		　　}
			return true;
		}
		
	</script>
</body>
</html>