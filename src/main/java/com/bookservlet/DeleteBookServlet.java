package com.bookservlet;

import com.dao.BookDao;
import com.daoimpl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public DeleteBookServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Bookid=request.getParameter("bookid");
        System.out.println(Bookid);
        BookDao service=new BookDaoImpl();
        request.getRequestDispatcher("BookListServlet").forward(request,response);
        try {
            service.delete(Integer.parseInt(Bookid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            service.delete(Integer.parseInt(Bookid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
