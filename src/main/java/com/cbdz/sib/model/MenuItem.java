package com.cbdz.sib.model;

public class MenuItem extends MenuItemKey {
    private String itemLabel;

    private Integer itemDispno;

    private String itemType;

    private String itemPlaceholder;

    private String itemSelText;

    private String mustFlag;

    private String itemInitval;

    public MenuItem(String mCode, String itemId, String itemLabel, Integer itemDispno, String itemType, String itemPlaceholder, String itemSelText, String mustFlag, String itemInitval) {
        super(mCode, itemId);
        this.itemLabel = itemLabel;
        this.itemDispno = itemDispno;
        this.itemType = itemType;
        this.itemPlaceholder = itemPlaceholder;
        this.itemSelText = itemSelText;
        this.mustFlag = mustFlag;
        this.itemInitval = itemInitval;
    }

    public MenuItem() {
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

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getItemPlaceholder() {
        return itemPlaceholder;
    }

    public void setItemPlaceholder(String itemPlaceholder) {
        this.itemPlaceholder = itemPlaceholder == null ? null : itemPlaceholder.trim();
    }

    public String getItemSelText() {
        return itemSelText;
    }

    public void setItemSelText(String itemSelText) {
        this.itemSelText = itemSelText == null ? null : itemSelText.trim();
    }

    public String getMustFlag() {
        return mustFlag;
    }

    public void setMustFlag(String mustFlag) {
        this.mustFlag = mustFlag == null ? null : mustFlag.trim();
    }

    public String getItemInitval() {
        return itemInitval;
    }

    public void setItemInitval(String itemInitval) {
        this.itemInitval = itemInitval == null ? null : itemInitval.trim();
    }
}