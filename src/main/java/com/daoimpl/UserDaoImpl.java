package com.daoimpl;

import com.bean.PageBean;
import com.bean.User;
import com.dao.UserDao;
import com.tool.JDBCUtil;
import com.tool.TextUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findUserByPage(int currentPage) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from users",new BeanListHandler<User>(User.class));
    }

    @Override
    public List<User> findAll() throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from users",new BeanListHandler<User>(User.class));
    }

    @Override
    public void insert(User user) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        runner.update("insert into users (`username`,`passwords`,`birthday`,`sex`,`usertype`,`isfull`,`money`) values (?,?,?,?,?,?,?)",
        user.getUsername(),
        user.getPasswords(),
        user.getBirthday(),
        user.getSex(),
        user.getusertype(),
        user.getIsfull(),
        user.getMoney()
        );
    }

    @Override
    public User searchUserForLogin(String username, String password, String usertype) throws SQLException {
        System.out.println(username+"---"+password+"-----"+usertype);
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        User user = runner.query("select * from users where username=? and passwords=? and usertype = ?", new BeanHandler<User>(User.class),username,password,usertype);
        System.out.println(user);
        return runner.query("select * from users where username=? and passwords=? and usertype = ?", new BeanHandler<User>(User.class),username,password,usertype);    }

    @Override
    public List<User> searchUser(String username, String usertype) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        String sql="select * from users where 1=1";
        List<String>list=new ArrayList<>();
        if(!TextUtils.isEmpty(username)){
            sql=sql+" and username like ?";
            list.add("%"+username+"%");
        }
        System.out.println(username);
        if(!TextUtils.isEmpty(usertype)){
            sql=sql+" and usertype=?";
            list.add(String.valueOf(usertype));
        }
        System.out.println(usertype);
        System.out.println(sql);
        return runner.query(sql,new BeanListHandler<User>(User.class),list.toArray());
    }

    @Override
    public void delete(int userid) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        runner.update("delete from users where userid=?",userid);
        System.out.println("delete from users where userid="+userid);
    }

    @Override
    public void update(User user) throws SQLException {
        QueryRunner runner=new QueryRunner(JDBCUtil.getDataSource());
        runner.update("update users set username =?,passwords=?,birthday=?,sex=?,usertype=?,isfull=?,money=? where  userid=?",
                user.getUsername(),
                user.getPasswords(),
                user.getBirthday(),
                user.getSex(),
                user.getusertype(),
                user.getIsfull(),
                user.getMoney(),
                user.getUserid()
        );
    }

    @Override
    public User findUserById(int userid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        return runner.query("select * from users where userid = ?", new BeanHandler<User>(User.class),userid);
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
        Long  result = (Long) runner.query("SELECT COUNT(*) FROM users" , new ScalarHandler() );
        return result.intValue();
    }

    @Override
    public PageBean findUserByPages(int currentPage) throws SQLException {
        PageBean<User> pageBean = new PageBean<User>();

        int pageSize = UserDao.PAGE_SIZE ;
        pageBean.setCurrentPage(currentPage); //设置当前页
        pageBean.setPageSize(pageSize); //设置每页显示多少记录

        UserDao dao = new UserDaoImpl() ;
        List<User> list =dao .findUserByPage(currentPage);
        pageBean.setList(list); //设置这一页的学生数据

        //总的记录数， 总的页数。
        int count = dao.findCount();
        pageBean.setTotalSize(count); //设置总的记录数
        //200 ， 10 ==20   201 ， 10 = 21   201 % 10 == 0 ?201 / 10 :201 % 10 + 1
        pageBean.setTotalPage(count % pageSize==0 ? count / pageSize : (count / pageSize) + 1); //总页数
        return pageBean;
    }
}
