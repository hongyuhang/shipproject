package com.cbdz.sib.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 *
 * @author hongyuhang
 *
 */
public abstract class BaseModel {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifiedTime;

    private String creatorFk;
    private String creatorName;
    private String modifierFk;
    private String modifierName;

    private String ambiguousKeyWord;

    private boolean valid = true;

    private int seq = 0;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatorFk() {
        return creatorFk;
    }

    public void setCreatorFk(String creatorFk) {
        this.creatorFk = creatorFk == null ? null : creatorFk.trim();
    }

    public String getModifierFk() {
        return modifierFk;
    }

    public void setModifierFk(String modifierFk) {
        this.modifierFk = modifierFk == null ? null : modifierFk.trim();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getAmbiguousKeyWord() {
        return ambiguousKeyWord;
    }

    public void setAmbiguousKeyWord(String ambiguousKeyWord) {
        this.ambiguousKeyWord = ambiguousKeyWord;
    }
}