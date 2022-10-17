<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/Super/Super_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item    "><a href="<%=request.getContextPath() %>/UserListServlet"><span
							style="color: black">用户信息</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/BookListServlet"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/Super/Super_AddUser.jsp"><span
							style="color: black">添加用户</span></a></li>
					<li class="list-group-item active"><a href="<%=request.getContextPath() %>/SBook/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Super/Super_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>

			<div class="col-md-9">
				<div class="container" align="center">
					<form action="<%=request.getContextPath()%>/UpdateBookServlet" method="post">
						<input type="hidden" name = "bookid" value="${Book.bookid}">
						<table align="center">
							<tr>
								<td align="center"><b>图书名称:</b></td>
								<td><input type="text" name="bookname" value="${Book.bookname}"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
							  </tr>
							<tr>
								<td align="center"><b>作者:</b></td>
								<td><input type="text" name="author" value="${Book.author}"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
							  </tr>
							<tr>
								<td align="center"><b>出版社:</b></td>
								<td><input type="text" name="publish" value="${Book.publish}"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
							  </tr>
							<tr>
								<td align="center"><b>图书库存:</b></td>
								<td><input type="text" name="bookcount" value="${Book.bookcount}"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
							  </tr>
							<tr>
								<td align="center"><b>图书类型:</b></td>
								<td><input type="text" name="booktype" value="${Book.booktype}"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
							  </tr>
							  

						</table>
						<button type="submit" style="margin-left: 20px; margin-top: 30px;"
							class="btn btn-info">确认信息</button>

						<a href="Super_about.jsp" class="btn btn-danger"
							style="margin-left: 80px; margin-top: 30px;"><span>取消</span></a>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>