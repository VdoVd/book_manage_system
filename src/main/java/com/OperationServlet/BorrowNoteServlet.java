package com.OperationServlet;

import com.bean.PageBean;
import com.dao.OperaBookDao;
import com.daoimpl.OperaBookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/BorrowNoteServlet")
public class BorrowNoteServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public BorrowNoteServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage=1;
        if(request.getParameter("currentPage")!=null){
            currentPage=Integer.parseInt(request.getParameter("currentPage"));
            OperaBookDao bookService=new OperaBookDaoImpl();
            try {
                PageBean pageBean=bookService.findAlls(currentPage);
                request.setAttribute("pageBean",pageBean);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            request.getRequestDispatcher("/bookManager/BorrowNote.jsp").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
