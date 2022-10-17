<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用图书馆管理系统</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body background="img/background.jpg" style="width: 100%; height: 100%;">
	<div align="center" style="margin-top: 20px"><img alt="图书管理系统" src="img/logo_index.png"></div>
	<!-- 文字滚动 -->
	<MARQUEE scrollAmount=10 direction=left>博文 明理 厚德 尚能</MARQUEE>
	<!-- 使用百分比设置表单位置始终居中 -->
		<form style="margin-left:40%;margin-top:5%;" action="LoginCheck" method="post">
         <div class="form-group">
             <label for="user" stype="display:inline;">账户：</label>
            <input type="text" class="form-control" name="username" style="display:inline;width:200px;"autocomplete="off" />
         </div>
         <div class="form-group">
             <label for="password" style="display:inline;">密码：</label>
             <input type="password" class="form-control" name="password" style="display:inline;width:200px;"autocomplete="off" />
         </div>
         <div class="form-group">
             <label for="usertype" style="display:inline;">类型：</label>
         <select class="dropdown" name="usertype" style="display:inline;">
				<option value = "-1">系统管理员</option>
				<option value = "0">图书管理员</option>
				<option value = "1">读者</option>
		</select>		
         </div>
	         <button type="submit" class="btn" >登录</button>
     </form>
     <!-- 若登陆失败，弹窗提醒 -->
     		<%
		   String mess=(String)session.getAttribute("message");
		   if(mess==null){
		        
		   }
			else{%>
				<script type="text/javascript">	  
					alert("<%=mess%>");
				</script>
			<%
			session.setAttribute("message",null);
			%>
			<% }%>
			
</body>
</html>