package com.cbdz.sib.dao;

import com.cbdz.sib.model.MmsiCurrent;
import com.cbdz.sib.model.MmsiCurrentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MmsiCurrentMapper {
    long countByExample(MmsiCurrentExample example);

    int deleteByExample(MmsiCurrentExample example);

    int deleteByPrimaryKey(Long seq);

    int insert(MmsiCurrent record);

    int insertSelective(MmsiCurrent record);

    List<MmsiCurrent> selectByExample(MmsiCurrentExample example);

    MmsiCurrent selectByPrimaryKey(Long seq);

    int updateByExampleSelective(@Param("record") MmsiCurrent record, @Param("example") MmsiCurrentExample example);

    int updateByExample(@Param("record") MmsiCurrent record, @Param("example") MmsiCurrentExample example);

    int updateByPrimaryKeySelective(MmsiCurrent record);

    int updateByPrimaryKey(MmsiCurrent record);
}