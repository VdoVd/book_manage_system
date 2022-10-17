package com.dao;

import com.bean.Book;
import com.bean.OperaBook;
import com.bean.PageBean;
import com.bean.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface OperaBookDao {
    void BorrowBooks(Book book, User user, Date date);
    void ReturnBooks(Book book,User user,Date date);
    void RenewBook(Book book,User user,Date date);
    int PAGE_SIZE=5;
    List<OperaBook>findAll(int currentPage)throws SQLException;
    PageBean findAlls(int currentPage)throws SQLException;
    List<OperaBook>findOperaByUserid(int userid)throws SQLException;
    List<OperaBook>findOperaByINT(String bookname,String username,boolean isreturn)throws SQLException;
    int CountBorrowBooks(Book book,User user);
    int findCount()throws SQLException;
    void deleteOperaBooks(String operatid)throws SQLException;
}
