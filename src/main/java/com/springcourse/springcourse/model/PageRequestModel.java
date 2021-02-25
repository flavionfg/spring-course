package com.springcourse.springcourse.model;

public class PageRequestModel {

    private int page;
    private int size;

    public PageRequestModel(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public PageRequestModel() {
    }

    public int getPage() {
        return this.page;
    }

    public int getSize() {
        return this.size;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
