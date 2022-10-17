package com.OperationServlet;

import com.bean.Book;
import com.bean.User;
import com.bookservlet.BookListServlet;
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

@WebServlet("/BorrowBooksServlet")
public class BorrowBooksServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public BorrowBooksServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hehehe");
        int Bookid=Integer.parseInt(request.getParameter("bookid"));
        System.out.println(Bookid);
        BookDao Dao=new BookDaoImpl();
        Book book= null;
        try {
            book = Dao.findBookById(Bookid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(book.toString());

        request.setAttribute("Book",book);
        if(request.getParameter("userid")==null){
            request.getRequestDispatcher("bookManage/BorrowBook.jsp").forward(request,response);
        }else {
            int userid = Integer.parseInt(request.getParameter("userid"));
            UserDao userDao = new UserDaoImpl();
            User user = null;
            try {
                user = userDao.findUserById(userid);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println(user.toString());
            request.setAttribute("user",user);
            OperaBookDao bookDao=new OperaBookDaoImpl();
            bookDao.BorrowBooks(book,user,new Date());
            request.getRequestDispatcher("/BorrowNoteServlet").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
