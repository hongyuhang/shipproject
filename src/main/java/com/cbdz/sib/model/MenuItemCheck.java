package com.cbdz.sib.model;

public class MenuItemCheck extends MenuItemCheckKey {
    private String itemLabel;

    private String checkMethod;

    private String checkParam;

    private String errMsg;

    public MenuItemCheck(String mCode, String itemId, Integer checkNo, String itemLabel, String checkMethod, String checkParam, String errMsg) {
        super(mCode, itemId, checkNo);
        this.itemLabel = itemLabel;
        this.checkMethod = checkMethod;
        this.checkParam = checkParam;
        this.errMsg = errMsg;
    }

    public MenuItemCheck() {
        super();
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel == null ? null : itemLabel.trim();
    }

    public String getCheckMethod() {
        return checkMethod;
    }

    public void setCheckMethod(String checkMethod) {
        this.checkMethod = checkMethod == null ? null : checkMethod.trim();
    }

    public String getCheckParam() {
        return checkParam;
    }

    public void setCheckParam(String checkParam) {
        this.checkParam = checkParam == null ? null : checkParam.trim();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }
}