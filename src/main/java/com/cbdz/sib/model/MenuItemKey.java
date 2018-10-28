package com.cbdz.sib.model;

public class MenuItemKey {
    private String mCode;

    private String itemId;

    public MenuItemKey(String mCode, String itemId) {
        this.mCode = mCode;
        this.itemId = itemId;
    }

    public MenuItemKey() {
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
}