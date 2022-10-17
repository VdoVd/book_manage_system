<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to use book library manage system</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>
<body background="img/background.jpg" style="width: 100%; height: 100%;">
	<div align="center" style="margin-top: 20px"><img alt="图书管理系统" src="img/logo_index.png"></div>
	<MARQUEE scrollAmount=10 direction=left>Book Manage</MARQUEE>
	<!--set center-->
		<form style="margin-left:40%;margin-top:5%;" action="LoginCheck" method="post">
         <div class="form-group">
             <label for="user" stype="display:inline;">Account:</label>
            <input type="text" class="form-control" name="username" style="display:inline;width:200px;"autocomplete="off" />
         </div>
         <div class="form-group">
             <label for="password" style="display:inline;">password:</label>
             <input type="password" class="form-control" name="password" style="display:inline;width:200px;"autocomplete="off" />
         </div>
         <div class="form-group">
             <label for="usertype" style="display:inline;">type:</label>
         <select class="dropdown" name="usertype" style="display:inline;">
				<option value = "-1">system manager</option>
				<option value = "0">book manager</option>
				<option value = "1">reader</option>
		</select>		
         </div>
	         <button type="submit" class="btn" >login</button>
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