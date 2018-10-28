package com.cbdz.sib.dao;

import com.cbdz.sib.model.MenuItem;
import com.cbdz.sib.model.MenuItemExample;
import com.cbdz.sib.model.MenuItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuItemMapper {
    long countByExample(MenuItemExample example);

    int deleteByExample(MenuItemExample example);

    int deleteByPrimaryKey(MenuItemKey key);

    int insert(MenuItem record);

    int insertSelective(MenuItem record);

    List<MenuItem> selectByExample(MenuItemExample example);

    MenuItem selectByPrimaryKey(MenuItemKey key);

    int updateByExampleSelective(@Param("record") MenuItem record, @Param("example") MenuItemExample example);

    int updateByExample(@Param("record") MenuItem record, @Param("example") MenuItemExample example);

    int updateByPrimaryKeySelective(MenuItem record);

    int updateByPrimaryKey(MenuItem record);
}