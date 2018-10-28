package com.cbdz.sib.model;

public class MenuItemInitvalKey {
    private String mCode;

    private String itemId;

    private Integer histNo;

    public MenuItemInitvalKey(String mCode, String itemId, Integer histNo) {
        this.mCode = mCode;
        this.itemId = itemId;
        this.histNo = histNo;
    }

    public MenuItemInitvalKey() {
        super();
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode == null ? null : mCode.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public Integer getHistNo() {
        return histNo;
    }

    public void setHistNo(Integer histNo) {
        this.histNo = histNo;
    }
}