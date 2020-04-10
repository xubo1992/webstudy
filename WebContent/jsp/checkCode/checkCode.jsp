<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/jquery-3.3.1.js"></script>
</head>
<body>
	<font>请输入验证码：</font><br/>
	<a href="javascript:reload()"><img src="img.jsp"></a>
	<input type="text" id="code" maxlength="4" onblur="checkCode()">
</body>
<script type="text/javascript">
	function checkCode(){
		var code = $("#code").val();
		$.ajax({
			url:"<%=request.getContextPath()%>"+"/CheckCodeServlet",
			type:"POST",
			data:"code="+code,
			success:function(result){
				if(result == "1"){
					alert("验证码输入正确");
				}else{
					alert("验证码输入有误");
				}
			}
		})
	}
	
	function reload(){
		$("img").attr("src","img.jsp?v="+new Date().getTime());
	}
</script>
</html>