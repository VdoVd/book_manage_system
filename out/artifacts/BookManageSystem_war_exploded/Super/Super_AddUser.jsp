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
	<h2 align="center" style="margin-top: 20px;">图书管理系统首页</h2>
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
					<li class="list-group-item active"><a href="<%=request.getContextPath() %>/Super/Super_AddUser.jsp"><span
							style="color: black">添加用户</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Book/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Super/Super_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>

			<div class="col-md-9">
				<div class="container" align="center">
					<form action="<%=request.getContextPath()%>/AddUserServlet" method="post">
						<table align="center">
							<tr>
								<td align="center"><b>用户名:</b></td>
								<td><input type="text" name="username"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass" ></td>
							  </tr>
							  <tr>
								<td align="center"><b>性别</b></td>
								<td>
									<input type="radio" name="sex" value="男" style="margin-left: 50px; margin-top: 10px;">男
									<input type="radio" name="sex" value="女" style="margin-left: 50px; margin-top: 10px;">女
								</td>
							  </tr>
							  <tr>
								<td align="center"><b>密码</b></td>
								<td><input type="password" name="password"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass"></td>
							  </tr>
							  <tr>
								<td align="center"><b>生日</b></td>
								<td><input type="text" name="birthday"
								style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass form_date"></td>
							  </tr>
							  <tr>
								<td><b>用户类型</b></td>
								<td>
								<select name="usertype" style="margin-left: 50px; margin-top: 10px;">
										<option value = "0">图书管理员</option>
										<option value = "1">读者</option>
										<option value = "-1">系统管理员</option>
									</select>		
								</td>
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
	<script type="text/javascript">
		$('.form_date').datetimepicker({
			format : 'yyyy-mm-dd',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
		});
	</script>
</body>
</html>