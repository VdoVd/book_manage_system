<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<style>
.imgs {
	width: 900px;
	height: 400px;
	background-position: center;
	background-size: cover;
}
</style>
</head>
<body background="<%=request.getContextPath()%>/img/background.jpg">
		<h2 align="center" style="margin-top:20px;">图书管理系统</h2>
		<div class="container">
		<div class="row " style="margin-top: 50px;">
			<div align="center" class="col-md-3" >
				<ul class="list-group" >
				<c:if test="${sessionScope.usertype=='1'}">
					<li class="list-group-item"><span
							style="color: black">首页</span></li>
					<li class="list-group-item"><a href="BookListServlet"><span
							style="color: black">图书信息查询</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/SearchOperatServlet?username=${username}"><span
							style="color: black">我的借阅记录</span></a></li>
					<li class="list-group-item active"><a href="Reader/exit.jsp"><span
							style="color: black">退出</span></a></li>
				</c:if>
							
					<c:if test="${sessionScope.usertype=='0'}">
					<li class="list-group-item"><a href="<%=request.getContextPath()%>/bookManager/bookManager_about.jsp"><span
						style="color: black">首页</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath()%>/BookListServlet"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item  active"><a href="<%=request.getContextPath() %>/Book/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/bookManager/BorrowBook.jsp"><span
							style="color: black">借书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/bookManager/BorrowNote.jsp"><span
							style="color: black">借阅记录查询</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/Reader/exit.jsp"><span
							style="color: black">退出</span></a></li>
				</c:if>
				</ul>
			</div>
			<div class="col-md-9" align="center" style="border: 1px solid black;">
				<h3 align="center" style="padding-top: 20px;">确定要退出吗？</h3>
				<div align="center" style="padding-top: 80px; width: 250px;"
					class=" row">
					<a href="<%=request.getContextPath()%>/ExitServlet" class="btn btn-danger "
						style="width: 80px; margin-right: 75px;"> 退出</a>
					<button class="btn btn-info " style="width: 80px">取消</button>
				</div>
			</div>
		</div>
		</div>
</body>
</html>