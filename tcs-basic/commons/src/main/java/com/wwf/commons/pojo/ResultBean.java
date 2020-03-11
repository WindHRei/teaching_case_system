package com.wwf.commons.pojo;

import java.io.Serializable;

/**
 * @author WangWeifeng
 * @date 2020-2-29 下午 7:14
 */

public class ResultBean<T> implements Serializable {
    private String status;
    private T t;

    public ResultBean(String status, T t) {
        this.status = status;
        this.t = t;
    }

    public ResultBean() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
