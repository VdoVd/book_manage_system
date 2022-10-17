package com.dao;

import com.bean.Book;
import com.bean.PageBean;

import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.List;

public interface BookDao {
    int PAGE_SIZE=5;
    List<Book>findBookByPage(int currentPage)throws SQLException;
    PageBean findBookByPages(int currentPage)throws SQLException;
    List<Book>findAll()throws SQLException;
    List<Book> searchBook(String Bookname,String Booktype) throws SQLException ;
    void insert(Book book)throws SQLException;
    void delete(int Bookid)throws SQLException;
    void update(Book book)throws SQLException;
    Book findBookById(int Bookid)throws SQLException;
    int findCount()throws SQLException;
}
