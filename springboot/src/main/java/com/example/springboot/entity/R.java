package com.example.springboot.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private Integer code;

    private String msg;

    private Object data;

    public R() {
    }

    public R(RCode rCode,T data) {
        this.code = rCode.getCode();
        this.msg = rCode.getMsg();
        this.data = data;
    }

    public static <T> R success(T data){
        return new R(RCode.SUCCESS,data);
    }

    public static R failure(RCode rCode){
        return new R(rCode,null);
    }
}
