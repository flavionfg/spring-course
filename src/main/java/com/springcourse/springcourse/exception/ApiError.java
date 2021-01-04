package com.springcourse.springcourse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class ApiError implements Serializable {

    private int code;
    private String msg;
    private Date date;

}
