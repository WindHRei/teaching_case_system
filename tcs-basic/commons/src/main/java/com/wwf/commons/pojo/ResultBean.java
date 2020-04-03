package com.wwf.commons.pojo;

import java.io.Serializable;

/**
 * @author WangWeifeng
 * @date 2020-2-29 下午 7:14
 */

public class ResultBean<T> implements Serializable {
    private String status;
    private T data;

    public ResultBean(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResultBean() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
