package com.cbdz.sib.model;

public class Menu {
    private String mCode;

    private String mName;

    private Integer mLevel;

    private Integer mDispno;

    public Menu(String mCode, String mName, Integer mLevel, Integer mDispno) {
        this.mCode = mCode;
        this.mName = mName;
        this.mLevel = mLevel;
        this.mDispno = mDispno;
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
}