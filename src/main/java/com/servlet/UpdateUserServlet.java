package com.servlet;


import com.bean.User;
import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			//1. 获取客户端提交上来的数据
			System.out.println(request.getParameter("userid"));
			int userid = Integer.parseInt(request.getParameter("userid"));
			String username = request.getParameter("username");
			String passwords = request.getParameter("password");
			String birthday = request.getParameter("birthday");
			String sex = request.getParameter("sex");
			System.out.println(sex);
			int usertype = Integer.parseInt(request.getParameter("usertype"));
			String isfull = "0";
			double money = 0;
			//2. 添加到数据库
			//string -- date
			Date date= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
			
			User User = new User(userid,username, passwords,date,sex, usertype, isfull, money);
			UserDao service = new UserDaoImpl();
			service.update(User);
			
			//3. 跳转到列表页
			//再查一次数据库，然后再装到作用域中 ，然后再跳转。
			//这里是直接跳转到页面上， 那么这个页面会重新翻译一次，上面的那个request的请求存放的数据是没有了。 
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			
			//servlet除了能跳jsp之外。 还能跳servlet
			request.getRequestDispatcher("UserListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
