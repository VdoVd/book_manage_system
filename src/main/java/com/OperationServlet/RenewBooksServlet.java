package com.OperationServlet;


import com.bean.Book;
import com.bean.User;
import com.dao.BookDao;
import com.dao.OperaBookDao;
import com.dao.UserDao;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.OperaBookDaoImpl;
import com.daoimpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/RenewBooksServlet")
public class RenewBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RenewBooksServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(request.getParameter("userid"));
			System.out.println(request.getParameter("bookid"));
			//1. 接收id
			int Bookid = Integer.parseInt(request.getParameter("bookid"));
			System.out.println(Bookid);
			//2. 查询数据
			BookDao service = new BookDaoImpl();
			Book Book = service.findBookById(Bookid);
			System.out.println(Book.toString());
			//3. 显示数据
			//存数据
			request.setAttribute("Book", Book);
			if(request.getParameter("userid")==null) {
				request.getRequestDispatcher("Book/ReturnBooks.jsp").forward(request, response);
			}else {
				int userid = Integer.parseInt(request.getParameter("userid"));
			//2. 查询数据
			UserDao Userservice = new UserDaoImpl();
			User user = Userservice.findUserById(userid);
			System.out.println(user.toString());
			//3. 显示数据
			//存数据
			request.setAttribute("user", user);
			OperaBookDao bookService = new OperaBookDaoImpl();
			bookService.RenewBook(Book, user, new Date());
			request.getRequestDispatcher("/BorrowNoteServlet").forward(request, response);
	
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
