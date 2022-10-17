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
<link href="./css/bootstrap-datetimepicker.min.css" rel="stylesheet"
	media="screen">
<script type="text/javascript" src="./css/bootstrap-datetimepicker.js"></script>
<style>
.imgs {
	width: 900px;
	height: 400px;
	background-position: center;
	background-size: cover;
}
</style>
</head>
<body background="../img/background.jpg">
	<h2 align="center" style="margin-top: 20px;">添加图书</h2>
	<div class="container">
		<div class="row " style="margin-top: 50px;">
			<div align="center" class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item"><a href="<%=request.getContextPath()%>/bookManager/bookManager_about.jsp"><span
						style="color: black">首页</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath()%>/BookListServlet"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/Book/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item  active"><a href="<%=request.getContextPath() %>/bookManager/BorrowBook.jsp"><span
							style="color: black">借书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/BorrowNoteServlet"><span
							style="color: black">借阅记录查询</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/Reader/exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>

			<div class="col-md-9">
				<div class="container" align="center">
					<form action="">
						<table>
						<tr align="center">
						<td><b>图书编号</b></td>
						<td><input type="text" name="bookid" value="${Book.bookid}" style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
					  </tr>
					  <tr align="center">
						<td><b>图书名称</b></td>
						<td><input type="text" name="bookname" value="${Book.bookname}" style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
					  </tr>
					  <tr align="center">
						<td><b>借阅人编号</b></td>
						<td><input type="text" name="userid" style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
					  </tr>
					  <tr>
						<td colspan="2"> <input type="submit" value="确认" style="margin-left: 20px; margin-top: 30px;"
							class="btn btn-info"></td>
					  </tr>
					</table>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>