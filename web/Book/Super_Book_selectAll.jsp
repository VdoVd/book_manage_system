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
	function doDelete(bookid) {
		/* 如果这里弹出的对话框，用户点击的是确定，就马上去请求Servlet。 
		如何知道用户点击的是确定。
		如何在js的方法中请求servlet。 */
		var flag = confirm("是否确定删除?");
		if(flag){
			//表明点了确定。 访问servlet。 在当前标签页上打开 超链接，
			//window.location.href="DeleteServlet?sid="+sid;
			location.href="DeleteBookServlet?bookid="+bookid;
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
				<c:if test="${sessionScope.usertype=='-1'}">
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/Super/Super_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/UserListServlet"><span
							style="color: black">用户信息</span></a></li>
					<li class="list-group-item  active"><a href="<%=request.getContextPath() %>/BookListServlet"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Super/Super_AddUser.jsp"><span
							style="color: black">添加用户</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Book/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/Super/Super_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</c:if>
				<c:if test="${sessionScope.usertype=='1'}">
					<li class="list-group-item"><span
							style="color: black">首页</span></li>
					<li class="list-group-item  active"><a href="/BookListServlet"><span
							style="color: black">图书信息查询</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath() %>/SearchOperatServlet?username=${username}"><span
							style="color: black">我的借阅记录</span></a></li>
					<li class="list-group-item "><a href="Reader/exit.jsp"><span
							style="color: black">退出</span></a></li>
				</c:if>
				<c:if test="${sessionScope.usertype=='0'}">
					<li class="list-group-item"><a href="<%=request.getContextPath()%>/bookManager/bookManager_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item active"><a href="<%=request.getContextPath()%>/BookListServlet"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/Book/AddBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item"><a href="<%=request.getContextPath() %>/bookManager/BorrowBook.jsp"><span
							style="color: black">借书</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/BorrowNoteServlet"><span
							style="color: black">借阅记录查询</span></a></li>
					<li class="list-group-item "><a href="<%=request.getContextPath()%>/exit.jsp"><span
							style="color: black">退出</span></a></li>
				</c:if>
				</ul>
			</div>
			<div class="col-md-9">
				<table class="table table-bordered">
							  <tr align="center">
						<td>图书id</td>
						<td>图书名称</td>
						<td>作者</td>
						<td>出版社</td>
						<td>图书库存</td>
						<td>图书类型</td>
						<c:if test="${sessionScope.usertype!='1'}"><td>操作</td></c:if>
						</tr>
						 <c:forEach items="${pageBean.list }" var="book">
						 <tr align="center">
						<td>${book.bookid}</td>
						<td>${book.bookname}</td>
						<td>${book.author}</td>
						<td>${book.publish}</td>
						<td>${book.bookcount}</td>
						<td>${book.booktype}</td>
						<c:if test="${sessionScope.usertype=='-1'}">
							<td>
								<a href="EditBookServlet?bookid=${book.bookid }">更新</a>   
								<a href="#" onclick="doDelete(${book.bookid})">删除</a>
							</td>	
						</c:if>
						<c:if test="${sessionScope.usertype=='0'}">
							<c:if test="${book.bookcount>0}">
								<td>
										<a href="BorrowBooksServlet?bookid=${book.bookid }">借书</a>
								</td>
							</c:if>
						</c:if>				
						
						</tr>
						</c:forEach>
			  		<tr>
			  	<td colspan="7">
			  		第 ${pageBean.currentPage } / ${pageBean.totalPage }
			  		&nbsp;&nbsp;
			  		每页显示${pageBean.pageSize }条  &nbsp;&nbsp;&nbsp;
			  		总的记录数${pageBean.totalSize } &nbsp;&nbsp;&nbsp;
			  		<c:if test="${pageBean.currentPage !=1 }">
			  			<a href="BookListServlet?currentPage=1">首页</a>
						| <a href="BookListServlet?currentPage=${pageBean.currentPage-1 }">上一页</a>
			  		</c:if>
			  		
			  		<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
			  			<c:if test="${pageBean.currentPage == i }">
			  				${i }
			  			</c:if>
			  			<c:if test="${pageBean.currentPage != i }">
			  				<a href="BookListServlet?currentPage=${i }">${i }</a>
			  			</c:if>
			  		
			  		</c:forEach>
			  		
			  		
			  		<c:if test="${pageBean.currentPage !=pageBean.totalPage }">
			  			<a href="BookListServlet?currentPage=${pageBean.currentPage+1 }">下一页</a> | 
			  			<a href="BookListServlet?currentPage=${pageBean.totalPage }">尾页</a>
			  		</c:if>
			  	</td>
			  </tr>
				</table>
				
				<nav class="text-center">
				<ul class="pagination">
					<!-- 上一页 -->
					<li class="page-item"><a href="BookListServlet?currentPage=${pageBean.currentPage-1 }" class="page-link"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<!-- 页码 -->
					<!-- 下一页 -->
					<li class="page-item"><a href="BookListServlet?currentPage=${pageBean.currentPage+1 }" class="page-link"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>

</body>
</html>