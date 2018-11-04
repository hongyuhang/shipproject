package com.cbdz.sib.model;

import java.math.BigDecimal;
import java.util.Date;

public class MmsiHistory {
    private Long seq;

    private Date rTime;

    private String mmsi;

    private String name;

    private Integer length;

    private Integer width;

    private BigDecimal speed;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Date reportTime;

    private String useFlag;

    public MmsiHistory(Long seq, Date rTime, String mmsi, String name, Integer length, Integer width, BigDecimal speed, BigDecimal longitude, BigDecimal latitude, Date reportTime, String useFlag) {
        this.seq = seq;
        this.rTime = rTime;
        this.mmsi = mmsi;
        this.name = name;
        this.length = length;
        this.width = width;
        this.speed = speed;
        this.longitude = longitude;
        this.latitude = latitude;
        this.reportTime = reportTime;
        this.useFlag = useFlag;
    }

    public MmsiHistory() {
        super();
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi == null ? null : mmsi.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag == null ? null : useFlag.trim();
    }
}