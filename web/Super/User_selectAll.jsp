<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	function doDelete(userid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteServlet?Userid="+userid;
		}
	}
</script>
</head>
<body background="<%=request.getContextPath() %>/img/background.jpg">
	<h2 align="center" style="margin-top: 20px;">图书管理系统</h2>
	<div class="container">
		<div class="row " style="margin-top: 50px;">
			<div align="center" class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/Super/Super_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item active"><a href="<%=request.getContextPath() %>/UserListServlet"><span
							style="color: black">用户信息</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/BookListServlet"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Super/Super_AddUser.jsp"><span
							style="color: black">添加用户</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Book/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Super/Super_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<table class="table table-bordered">
					<tr>
						<td>用户id</td>
						<td>用户名</td>
						<td>密码</td>
						<td>生日</td>
						<td>性别</td>
						<td>用户类型</td>
						<td>账号状态</td>
						<td>欠费金额</td>
						<td>操作</td>
					</tr>

					<c:forEach items="${pageBean.list }" var="users">
				  <tr align="center">
					<td>${users.userid }</td>
					<td>${users.username }</td>
					<td>${users.passwords }</td>
					<td>${users.birthday }</td>
					<td>${users.sex }</td>
					<td>
					<c:if test="${users.usertype == 0}">图书管理员</c:if>
					<c:if test="${users.usertype == 1}">读者</c:if>
					<c:if test="${users.usertype == -1}">系统管理员</c:if> 
					</td>
					<td>
					<c:if test="${users.isfull == '0'}">正常</c:if>
					<c:if test="${users.isfull == '1'}">欠费</c:if>
					</td>
					<td>${users.money }</td>
					<td><a href="EditUserServlet?userid=${users.userid }">更新</a>   <a href="#" onclick="doDelete(${users.userid})">删除</a></td>
				  </tr>
			  </c:forEach>
			  		<tr>
			  	<td colspan="9">
			  		第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="UserListServlet?currentPage=1">首页</a>
						| <a href="UserListServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="UserListServlet?currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="UserListServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="UserListServlet?currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
				</table>
				
				<nav class="text-center">
				<ul class="pagination">
					<!-- 上一页 -->
					<li class="page-item"><a href="UserListServlet?currentPage=${pageBean.currentPage-1 }" class="page-link"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<!-- 页码 -->
					<!-- 下一页 -->
					<li class="page-item"><a href="UserListServlet?currentPage=${pageBean.currentPage+1 }" class="page-link"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
				</nav>
				<a href="admin_addStudent.jsp" class="btn btn-default"><span>添加单个用户</span></a>
			</div>
		</div>
	</div>

</body>
</html>