package com.servlet;


import com.bean.User;
import com.daoimpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---------------------");
		User user = null;
		ResultSet rs = null;
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		request.getSession().setAttribute("usertype", usertype);
		try {
		user = new UserDaoImpl().searchUserForLogin(username, password, usertype);
		} catch (SQLException e) {
			System.out.println("login failed");
			e.printStackTrace();
		}
		if(user == null) {
			request.getSession().setAttribute("message", "用户名或密码或用户类型错误！！！");
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("欢迎用户:"+user.getUsername());
			request.getSession().setAttribute("userid", user.getUserid());
			request.getSession().setAttribute("username", username);
			request.setAttribute("loginFlag", 1);
			if(usertype.equals("-1")) {
				request.getRequestDispatcher("/Super/Super_about.jsp").forward(request, response);
			}else if(usertype.equals("0")) {
				request.getRequestDispatcher("/bookManager/bookManager_about.jsp").forward(request, response);
			}else if(usertype.equals("1")) {
				request.getRequestDispatcher("/Reader/Reader.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
