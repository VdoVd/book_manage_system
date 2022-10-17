package com.bean;

public class OperaBook {
    private int operatid;
    private int bookid;
    private String bookname;
    private int userid;
    private String username;
    private String borrowtime;
    private int renttime;
    private boolean isreturn;

    public OperaBook() {
        super();
    }
    public OperaBook(int operatid, int bookid, String bookname, int userid, String username, String borrowtime,
                     int renttime, boolean isreturn) {
        super();
        this.operatid = operatid;
        this.bookid = bookid;
        this.bookname = bookname;
        this.userid = userid;
        this.username = username;
        this.borrowtime = borrowtime;
        this.renttime = renttime;
        this.isreturn = isreturn;
    }
    public int getOperatid() {
        return operatid;
    }
    public void setOperatid(int operatid) {
        this.operatid = operatid;
    }
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public int getRenttime() {
        return renttime;
    }
    public void setRenttime(int renttime) {
        this.renttime = renttime;
    }
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getBorrowtime() {
        return borrowtime;
    }
    public void setBorrowtime(String borrowtime) {
        this.borrowtime = borrowtime;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean isIsreturn() {
        return isreturn;
    }
    public void setIsreturn(boolean isreturn) {
        this.isreturn = isreturn;
    }


}


