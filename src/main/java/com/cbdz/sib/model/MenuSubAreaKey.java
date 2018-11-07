package com.cbdz.sib.model;

public class MenuSubAreaKey {
    private String mCode;

    private Integer subAreaNo;

    private String itemId;

    public MenuSubAreaKey(String mCode, Integer subAreaNo, String itemId) {
        this.mCode = mCode;
        this.subAreaNo = subAreaNo;
        this.itemId = itemId;
    }

    public MenuSubAreaKey() {
        super();
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode == null ? null : mCode.trim();
    }

    public Integer getSubAreaNo() {
        return subAreaNo;
    }

    public void setSubAreaNo(Integer subAreaNo) {
        this.subAreaNo = subAreaNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }
}