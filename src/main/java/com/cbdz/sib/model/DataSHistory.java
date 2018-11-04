package com.cbdz.sib.model;

import java.util.Date;

public class DataSHistory {
    private Long seq;

    private Date sTime;

    private String mCode;

    private String msgCode;

    private String mName;

    private String sType;

    private String mmsi;

    private String retCode;

    private String retMsg;

    private String pageJson;

    private String sJson;

    private Integer execMs;

    public DataSHistory(Long seq, Date sTime, String mCode, String msgCode, String mName, String sType, String mmsi, String retCode, String retMsg, String pageJson, String sJson, Integer execMs) {
        this.seq = seq;
        this.sTime = sTime;
        this.mCode = mCode;
        this.msgCode = msgCode;
        this.mName = mName;
        this.sType = sType;
        this.mmsi = mmsi;
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.pageJson = pageJson;
        this.sJson = sJson;
        this.execMs = execMs;
    }

    public DataSHistory() {
        super();
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
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

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType == null ? null : sType.trim();
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi == null ? null : mmsi.trim();
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode == null ? null : retCode.trim();
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg == null ? null : retMsg.trim();
    }

    public String getPageJson() {
        return pageJson;
    }

    public void setPageJson(String pageJson) {
        this.pageJson = pageJson == null ? null : pageJson.trim();
    }

    public String getsJson() {
        return sJson;
    }

    public void setsJson(String sJson) {
        this.sJson = sJson == null ? null : sJson.trim();
    }

    public Integer getExecMs() {
        return execMs;
    }

    public void setExecMs(Integer execMs) {
        this.execMs = execMs;
    }
}