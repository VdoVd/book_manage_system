package com.OperationServlet;


import com.bean.OperaBook;
import com.dao.OperaBookDao;
import com.daoimpl.OperaBookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/SearchOperatServlet")
public class SearchOperatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchOperatServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String isreturn =  request.getParameter("isreturn");
		String bookname =  request.getParameter("bookname");
		String username =  request.getParameter("username");
		OperaBookDao Dao = new OperaBookDaoImpl();
		try {
			List<OperaBook> list =  Dao.findOperaByINT(bookname, username, Boolean.parseBoolean(isreturn));
			System.out.println("list的大小是："+list.size());
			for (OperaBook Book : list) {
				System.out.println("book="+Book);
			}
			
			request.setAttribute("BorrowNotelist", list);
			
			//3. 跳转界面。列表界面
			request.getRequestDispatcher("/bookManager/BorrowNote.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
