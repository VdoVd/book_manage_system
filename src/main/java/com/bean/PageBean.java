package com.bean;

import java.util.List;

public class PageBean<T> {
    private int currentPage; //ĺ˝ĺéĄ?
    private int totalPage;//ćťéĄľć?
    private int pageSize;//ćŻéĄľçčŽ°ĺ˝ć°
    private int totalSize; //ćťçčŽ°ĺ˝ć?
    private List<T> list; //


    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalSize() {
        return totalSize;
    }
    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }
    public List<T> getList() {
        return list;
    }
    public void setList(List<T> list) {
        this.list = list;
    }




}

