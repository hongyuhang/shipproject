package com.cbdz.sib.dao;

import com.cbdz.sib.model.DataSHistory;
import com.cbdz.sib.model.DataSHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DataSHistoryMapper {
    long countByExample(DataSHistoryExample example);

    int deleteByExample(DataSHistoryExample example);

    int deleteByPrimaryKey(Long seq);

    int insert(DataSHistory record);

    int insertSelective(DataSHistory record);

    List<DataSHistory> selectByExample(DataSHistoryExample example);

    DataSHistory selectByPrimaryKey(Long seq);

    int updateByExampleSelective(@Param("record") DataSHistory record, @Param("example") DataSHistoryExample example);

    int updateByExample(@Param("record") DataSHistory record, @Param("example") DataSHistoryExample example);

    int updateByPrimaryKeySelective(DataSHistory record);

    int updateByPrimaryKey(DataSHistory record);
}