package com.cbdz.sib.model;

public class MenuItemInitval extends MenuItemInitvalKey {
    private String itemLabel;

    private Integer itemDispno;

    private String itemInitval;

    public MenuItemInitval(String mCode, String itemId, Integer histNo, String itemLabel, Integer itemDispno, String itemInitval) {
        super(mCode, itemId, histNo);
        this.itemLabel = itemLabel;
        this.itemDispno = itemDispno;
        this.itemInitval = itemInitval;
    }

    public MenuItemInitval() {
        super();
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel == null ? null : itemLabel.trim();
    }

    public Integer getItemDispno() {
        return itemDispno;
    }

    public void setItemDispno(Integer itemDispno) {
        this.itemDispno = itemDispno;
    }

    public String getItemInitval() {
        return itemInitval;
    }

    public void setItemInitval(String itemInitval) {
        this.itemInitval = itemInitval == null ? null : itemInitval.trim();
    }
}