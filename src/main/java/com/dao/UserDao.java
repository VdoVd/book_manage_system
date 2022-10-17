package com.dao;

import com.bean.PageBean;
import com.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int PAGE_SIZE = 5;

    List<User> findUserByPage(int currentPage) throws SQLException;
    List<User> findAll()  throws SQLException ;

    void insert(User user) throws SQLException ;
    /**
     *  模糊查询
     * @param username
     * @param usertype
     * @return
     * @throws SQLException
     */
    User searchUserForLogin(String username,String password,String usertype) throws SQLException ;
    List<User> searchUser(String username,String usertype) throws SQLException ;
    /**
     * 删除用户
     * @param userid
     * @throws SQLException
     */
    void delete(int userid) throws SQLException ;

    void update (User user) throws SQLException ;
    //根据id找用
    User findUserById(int userid) throws SQLException;
    //查询总记录数
    int findCount()throws SQLException ;
    //分页查询用户信息
    public PageBean findUserByPages(int currentPage) throws SQLException;
}
