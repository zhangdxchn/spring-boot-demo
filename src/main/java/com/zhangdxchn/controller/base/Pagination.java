package com.zhangdxchn.controller.base;

/**
 * Created by zhangdx on 16/8/14.
 */
public class Pagination {
    private Integer next;
    private Integer limit;
    private Integer total;

    public Integer getNext() {
        return next;
    }

    public void setNext(Integer next) {
        this.next = next;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
