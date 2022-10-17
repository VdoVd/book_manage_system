package com.OperationServlet;

import com.dao.OperaBookDao;
import com.daoimpl.OperaBookDaoImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/DeleteOperaServlet")
public class DeleteOperaServlet extends HttpServlet {
    private static  final long serialVersionUID=1L;

    public DeleteOperaServlet(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            String Operaid=request.getParameter("Operaid");
            System.out.println("the id you need to delete");
            OperaBookDao service=new OperaBookDaoImpl();
            service.deleteOperaBooks(Operaid);
            request.getRequestDispatcher("/BorrowNoteServlet");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response){
        doGet(request,response);
    }
}
