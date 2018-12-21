package com.zhaowb.boot.backstage.msg;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @auther zwb
 * @create 2018-12-21 21:36
 */
public class TableResultResponse<T> implements Serializable {

    /**
     * 总记录数
     */
    private int total;
    /**
     * 列表数据
     */
    private List<T> rows;


    public TableResultResponse(int total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public TableResultResponse(Long total, List<T> rows) {
        this.total = total.intValue();
        this.rows = rows;
    }

    public TableResultResponse() {
    }

    public TableResultResponse<T> total(int total) {
        this.total = total;
        return this;
    }

    public TableResultResponse<T> total(List<T> rows) {
        this.rows = rows;
        return this;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
