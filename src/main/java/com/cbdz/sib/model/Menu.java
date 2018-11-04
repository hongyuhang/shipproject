package com.cbdz.sib.model;

public class Menu {
    private String mCode;

    private String msgCode;

    private String mName;

    private Integer mLevel;

    private Integer mDispno;

    private String mUrl;

    private String sendFlag;

    public Menu(String mCode, String msgCode, String mName, Integer mLevel, Integer mDispno, String mUrl, String sendFlag) {
        this.mCode = mCode;
        this.msgCode = msgCode;
        this.mName = mName;
        this.mLevel = mLevel;
        this.mDispno = mDispno;
        this.mUrl = mUrl;
        this.sendFlag = sendFlag;
    }

    public Menu() {
        super();
    }

    public String getmCode() {
        return mCode;
    }

    public void setmCode(String mCode) {
        this.mCode = mCode == null ? null : mCode.trim();
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode == null ? null : msgCode.trim();
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public Integer getmLevel() {
        return mLevel;
    }

    public void setmLevel(Integer mLevel) {
        this.mLevel = mLevel;
    }

    public Integer getmDispno() {
        return mDispno;
    }

    public void setmDispno(Integer mDispno) {
        this.mDispno = mDispno;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl == null ? null : mUrl.trim();
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag == null ? null : sendFlag.trim();
    }
}