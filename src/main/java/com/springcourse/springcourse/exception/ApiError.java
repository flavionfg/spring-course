package com.springcourse.springcourse.exception;

import java.io.Serializable;
import java.util.Date;

public class ApiError implements Serializable {

    private int code;
    private String msg;
    private Date date;

    public ApiError(int code, String msg, Date date) {
        this.code = code;
        this.msg = msg;
        this.date = date;
    }

    public ApiError() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Date getDate() {
        return this.date;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
