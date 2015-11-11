<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath %>style/login_style.css" />
<!-- icon -->
<link rel="shortcut icon" href="<%=basePath %>images/icon_mini.ico" type="image/x-icon" />
<script type="text/javascript" src="<%=basePath %>js/login_js.js"></script>
<script type="text/javascript">
	function afterLoad(){
		var text = $("message").innerHTML;
		if(text!=''){
			alert(text);
		}
	}
</script>
</head>
<body onload="afterLoad()">
	<div id="message" style="display:none">${message }</div>
	<div class="LoginWindow">
		<div>
			<form method="post" action="login.do" onsubmit="return user_input()"
				class="login">
				<p><label for="login">帐号:</label> <input type="text" name="username" id="id"value=""></p>
				<p><label for="password">密码:</label> <input type="password" name="passwd" id="password" value=""></p>
				<p class="login-submit"><button type="submit" class="login-button" style="border-radius:200px;">Login</button></p>
			</form>
		</div>
	</div>
</body>
</html>