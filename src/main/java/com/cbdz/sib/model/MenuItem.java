package com.cbdz.sib.model;

public class MenuItem extends MenuItemKey {
    private String itemLabel;

    private Integer itemDispno;

    private String itemType;

    private String itemPlaceholder;

    private String itemSelText;

    private String itemInitval;

    private String initEnableFlag;

    public MenuItem(String mCode, String itemId, String itemLabel, Integer itemDispno, String itemType, String itemPlaceholder, String itemSelText, String itemInitval, String initEnableFlag) {
        super(mCode, itemId);
        this.itemLabel = itemLabel;
        this.itemDispno = itemDispno;
        this.itemType = itemType;
        this.itemPlaceholder = itemPlaceholder;
        this.itemSelText = itemSelText;
        this.itemInitval = itemInitval;
        this.initEnableFlag = initEnableFlag;
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

    public String getItemInitval() {
        return itemInitval;
    }

    public void setItemInitval(String itemInitval) {
        this.itemInitval = itemInitval == null ? null : itemInitval.trim();
    }

    public String getInitEnableFlag() {
        return initEnableFlag;
    }

    public void setInitEnableFlag(String initEnableFlag) {
        this.initEnableFlag = initEnableFlag == null ? null : initEnableFlag.trim();
    }
}