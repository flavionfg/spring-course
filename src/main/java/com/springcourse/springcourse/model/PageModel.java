package com.springcourse.springcourse.model;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {

    private int totalElements;
    private int pageSize;
    private int totalPages;
    private List<T> elements;

    public PageModel(int totalElements, int pageSize, int totalPages, List<T> elements) {
        this.totalElements = totalElements;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.elements = elements;
    }

    public PageModel() {
    }

    public int getTotalElements() {
        return this.totalElements;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public List<T> getElements() {
        return this.elements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
}
