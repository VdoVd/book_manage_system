package com.daoimpl;

import com.bean.Book;
import com.bean.PageBean;
import com.dao.BookDao;
import com.tool.JDBCUtil;
import com.tool.TextUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao
{

    @Override
    public List<Book> findBookByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from book limit ? offset ?", new BeanListHandler<Book>(Book.class), PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
    }

    @Override
    public List<Book> findAll() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from book", new BeanListHandler<Book>(Book.class));
    }

    @Override
    public void insert(Book Book) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("insert into book (bookname,publish,author,bookcount,booktype) values(?,?,?,?,?)",
                Book.getBookname(),
                Book.getPublish(),
                Book.getAuthor(),
                Book.getBookcount(),
                Book.getBooktype()
        );
    }


    @Override
    public List<Book> searchBook(String Bookname, String Booktype) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from book where 1=1 ";
        List<String> list = new ArrayList<String>();
        if(!TextUtils.isEmpty(Bookname)){
            sql = sql + "  and bookname like ?";
            list.add("%"+Bookname+"%");
        }
        System.out.println(Bookname);
        if(!TextUtils.isEmpty(String.valueOf(Booktype))){
            sql = sql + " and booktype = ?";
            list.add(String.valueOf(Booktype));
        }
        System.out.println(Booktype);
        System.out.println(sql);
        return runner.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
    }

    @Override
    public void delete(int Bookid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        System.out.println("delete from book where bookid = "+Bookid);
        runner.update("delete from book where bookid = "+Bookid);
    }

    @Override
    public void update(Book Book) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("update book set `bookname`=?,`publish`=?,`author`=?,`bookcount`=?,`booktype`= ? where bookid=?",
                Book.getBookname(),
                Book.getPublish(),
                Book.getAuthor(),
                Book.getBookcount(),
                Book.getBooktype(),
                Book.getBookid());
    }

    @Override
    public Book findBookById(int Bookid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from book where bookid =?", new BeanHandler<Book>(Book.class),Bookid);
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        Long  result = (Long) runner.query("SELECT COUNT(*) FROM book" , new ScalarHandler() );
        return result.intValue();
    }

    @Override
    public PageBean findBookByPages(int currentPage) throws SQLException {
        //封装分页的该页数据
        PageBean<Book> pageBean = new PageBean<Book>();

        int pageSize = BookDao.PAGE_SIZE ;
        pageBean.setCurrentPage(currentPage); //设置当前页
        pageBean.setPageSize(pageSize); //设置每页显示多少记录

        BookDao dao = new BookDaoImpl() ;
        List<Book> list =dao .findBookByPage(currentPage);
        pageBean.setList(list); //设置这一页的学生数据
        //总的记录数， 总的页数。
        int count = dao.findCount();
        pageBean.setTotalSize(count); //设置总的记录数
        //200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
        pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
        return pageBean;
    }

}
