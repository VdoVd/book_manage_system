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
import java.sql.SQLException;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 接收id
			int userid = Integer.parseInt(request.getParameter("userid"));
			
			//2. 查询数据
			UserDao service = new UserDaoImpl();
			User user = service.findUserById(userid);
			System.out.println(user.toString());
			//3. 显示数据
			//存数据
			request.setAttribute("user", user);
			//跳转
			request.getRequestDispatcher("Super/Super_UpdateUser.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
