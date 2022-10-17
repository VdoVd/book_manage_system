package com.bean;

public class Book {
    private int bookid;
    private String bookname;
    private String publish;
    private int bookcount;
    private String booktype;
    private String author;
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
    public String getPublish() {
        return publish;
    }
    public void setPublish(String publish) {
        this.publish = publish;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getBookcount() {
        return bookcount;
    }
    public void setBookcount(int bookcount) {
        this.bookcount = bookcount;
    }
    public String getBooktype() {
        return booktype;
    }
    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public Book(int bookid, String bookname, String publish, int bookcount, String booktype, String author) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publish = publish;
        this.bookcount = bookcount;
        this.booktype = booktype;
        this.author = author;
    }

    public Book() {
        super();
    }
    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", bookname=" + bookname + ", publish=" + publish + ", author=" + author
                + ", bookcount=" + bookcount + ", booktype=" + booktype + "]";
    }

}

