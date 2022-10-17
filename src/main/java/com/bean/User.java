package com.bean;

import java.util.Date;

public class User {
    private int userid;
    private String username;
    private String passwords;
    private Date birthday;
    private String sex;
    private int usertype;
    private String isfull;
    private double money;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswords() {
        return passwords;
    }
    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getusertype() {
        return usertype;
    }
    public void setusertype(int usertype) {
        this.usertype = usertype;
    }
    public String getIsfull() {
        return isfull;
    }
    public void setIsfull(String isfull) {
        this.isfull = isfull;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", username=" + username + ", passwords=" + passwords + ", birthday="
                + birthday + ", sex=" + sex + ", usertype=" + usertype + ", isfull=" + isfull + ", money=" + money + "]";
    }


    public User(int userid, String username, String passwords, Date birthday, String sex, int usertype, String isfull,
                double money) {
        super();
        this.userid = userid;
        this.username = username;
        this.passwords = passwords;
        this.birthday = birthday;
        this.sex = sex;
        this.usertype = usertype;
        this.isfull = isfull;
        this.money = money;
    }
    public User() {
        super();
    }

}

