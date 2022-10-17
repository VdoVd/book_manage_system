package com.bookservlet;

import com.bean.Book;
import com.dao.BookDao;
import com.daoimpl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/EditBookService")
public class EditBookService extends HttpServlet {
    private static final long serialVersionUID=1L;

    public EditBookService(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int Bookid=Integer.parseInt(request.getParameter("bookid"));
            System.out.println(Bookid);
            BookDao service=new BookDaoImpl();
            Book book= null;
            book = service.findBookById(Bookid);
            request.setAttribute("Book",book);
            request.getRequestDispatcher("Book/UpdateBook.jsp").forward(request,  response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        }
        protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
        }
}
