package com.daoimpl;

import com.bean.Book;
import com.bean.OperaBook;
import com.bean.PageBean;
import com.bean.User;
import com.dao.OperaBookDao;
import com.dao.UserDao;
import com.tool.JDBCUtil;
import com.tool.TextUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OperaBookDaoImpl implements OperaBookDao {

    @Override
    public void BorrowBooks(Book Book, User User, Date date) {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

        try {
            runner.update("INSERT INTO `operatebook` (`bookid`,`bookname`,`userid`,`username`,`borrowtime`,`renttime`,isreturn)VALUES(?,?,?,?,?,?,?)",
                    Book.getBookid(),
                    Book.getBookname(),
                    User.getUserid(),
                    User.getUsername(),
                    date,
                    "30",
                    false);
            runner.update("UPDATE book SET  bookcount = bookcount - 1 WHERE bookid = ?",Book.getBookid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void ReturnBooks(Book Book, User User, Date date) {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        try {
            runner.update("UPDATE book SET  bookcount = bookcount + 1 WHERE bookid = ?",Book.getBookid());
            runner.update("UPDATE operatebook SET isreturn = true where bookid = ? and userid = ?",Book.getBookid(),User.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void RenewBook(Book Book, User User, Date date) {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        try {
            runner.update("UPDATE operatebook SET `renttime`= renttime + 30 WHERE bookid = ? and userid= ?",Book.getBookid(),User.getUserid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int CountBorrowBooks(Book Book, User User) {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        int i = 0;
        try {
            List<Object> colList = runner.query("SELECT COUNT(1) FROM operatebook WHERE bookid=? AND userid=? AND isreturn = FALSE", new ColumnListHandler(
                    "tname"),Book.getBookid(),User.getUserid());
            for (Iterator<Object> itr = colList.iterator(); itr.hasNext();) {
                i = Integer.parseInt((String) itr.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }



    /**
     * 分页的显示�?�阅纪录
     */
    @Override
    public List<OperaBook> findAll(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from operatebook limit ? offset ?", new BeanListHandler<OperaBook>(OperaBook.class), PAGE_SIZE , (currentPage-1)*PAGE_SIZE);
    }


    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        Long  result = (Long) runner.query("SELECT COUNT(*) FROM operatebook" , new ScalarHandler() );
        return result.intValue();
    }
    @Override
    public List<OperaBook> findOperaByINT(String bookname,String username,boolean isreturn) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "SELECT * FROM operatebook WHERE 1=1";
        List<String> list = new ArrayList<String>();
        if(!TextUtils.isEmpty(bookname)){
            sql = sql + " AND bookname LIKE "+"'%"+bookname+"%'";
        }
        System.out.println(bookname);
        if(!TextUtils.isEmpty(username)){
            sql = sql + " AND username = "+"'"+username+"'";
        }
        if(!TextUtils.isEmpty(String.valueOf(isreturn))){
            sql = sql + " and isreturn = "+String.valueOf(isreturn);
        }
        sql = sql +";";
        System.out.println(String.valueOf(isreturn));
        System.out.println(sql);
        System.out.println(list.toString());
        System.out.println(list.toArray().toString());
//		return runner.query(sql, new BeanListHandler<OperaBook>(OperaBook.class),list.toArray());
        return runner.query(sql, new BeanListHandler<OperaBook>(OperaBook.class));
    }
    @Override
    public void deleteOperaBooks(String operatid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        runner.update("DELETE FROM operatebook WHERE operatid = ?",operatid);
    }
    @Override
    public List<OperaBook> findOperaByUserid(int userid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("SELECT * FROM operatebook WHERE userid = ?", new BeanListHandler<OperaBook>(OperaBook.class),userid);
    }


    @Override
    public PageBean findAlls(int currentPage) throws SQLException {
        PageBean<OperaBook> pageBean = new PageBean<OperaBook>();
        int pageSize = UserDao.PAGE_SIZE ;
        pageBean.setCurrentPage(currentPage); //设置当前页
        pageBean.setPageSize(pageSize); //设置每页显示多少记录
        OperaBookDao dao = new OperaBookDaoImpl() ;
        List<OperaBook> list =dao.findAll(currentPage);
        pageBean.setList(list);
        //总的记录数， 总的页数。
        int count = dao.findCount();
        pageBean.setTotalSize(count); //设置总的记录数
        //200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
        pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
        return pageBean;
    }
}
