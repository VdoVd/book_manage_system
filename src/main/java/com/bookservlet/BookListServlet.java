package com.bookservlet;

import com.bean.PageBean;
import com.dao.BookDao;
import com.daoimpl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public BookListServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        try {
            int currentPage = 1;
            String Bookname = request.getParameter("bookname");
            String Booktype = request.getParameter("booktype");
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }
            BookDao service = new BookDaoImpl();
            PageBean pageBean = service.findBookByPages(currentPage);
            request.setAttribute("pageBean",pageBean);
            request.getRequestDispatcher("/Book/Super_Book_selectAll.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
