package com.cbdz.sib.common;

/**
 * 分页bean
 */

public class Paging {
    public static final int DEFALUT_LIMIT = 20;

    public static final int DEFALUT_OFFSET = 1;

    private int limit;

    private int offset;

    private int total;

    public Paging(int offset, int limit, int total) {
        this.limit = limit;
        this.offset = offset;
//		this.total = (total / limit) + (total % limit > 0 ? 1 : 0);
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}