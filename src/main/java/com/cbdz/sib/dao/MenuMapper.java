package com.cbdz.sib.dao;

import com.cbdz.sib.model.Menu;
import com.cbdz.sib.model.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(String mCode);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(String mCode);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}