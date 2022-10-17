package com.servlet;


import com.bean.PageBean;
import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1. 获取需要显示的页码数
			int currentPage = 1;
			if(request.getParameter("currentPage")!=null) {
				
				currentPage =Integer.parseInt( request.getParameter("currentPage"));
			}
			
			//2. 根据指定的页数，去获取该页的数据回来
			//List<User> --- list.jsp
			
			UserDao service = new UserDaoImpl();
			PageBean pageBean= service.findUserByPages(currentPage);
			request.setAttribute("pageBean", pageBean);
			//3. 跳转界面。
			request.getRequestDispatcher("/Super/User_selectAll.jsp").forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
