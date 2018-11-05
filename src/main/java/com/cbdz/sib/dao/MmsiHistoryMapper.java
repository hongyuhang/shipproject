package com.cbdz.sib.dao;

import com.cbdz.sib.model.MmsiHistory;
import com.cbdz.sib.model.MmsiHistoryExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsiHistoryMapper {
    long countByExample(MmsiHistoryExample example);

    int deleteByExample(MmsiHistoryExample example);

    int deleteByPrimaryKey(Long seq);

    int insert(MmsiHistory record);

    int insertSelective(MmsiHistory record);

    List<MmsiHistory> selectByExample(MmsiHistoryExample example);

    MmsiHistory selectByPrimaryKey(Long seq);

    int updateByExampleSelective(@Param("record") MmsiHistory record, @Param("example") MmsiHistoryExample example);

    int updateByExample(@Param("record") MmsiHistory record, @Param("example") MmsiHistoryExample example);

    int updateByPrimaryKeySelective(MmsiHistory record);

    int updateByPrimaryKey(MmsiHistory record);

    int saveMmsiHistory(Date r_time);
}