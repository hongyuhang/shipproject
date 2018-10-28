package com.cbdz.sib.model;

public class MenuItemCheckKey {
    private String mCode;

    private String itemId;

    private Integer checkNo;

    public MenuItemCheckKey(String mCode, String itemId, Integer checkNo) {
        this.mCode = mCode;
        this.itemId = itemId;
        this.checkNo = checkNo;
    }

    public MenuItemCheckKey() {
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

    public Integer getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(Integer checkNo) {
        this.checkNo = checkNo;
    }
}