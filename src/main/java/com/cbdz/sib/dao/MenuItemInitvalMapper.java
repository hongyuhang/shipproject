package com.cbdz.sib.dao;

import com.cbdz.sib.model.MenuItemInitval;
import com.cbdz.sib.model.MenuItemInitvalExample;
import com.cbdz.sib.model.MenuItemInitvalKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuItemInitvalMapper {
    long countByExample(MenuItemInitvalExample example);

    int deleteByExample(MenuItemInitvalExample example);

    int deleteByPrimaryKey(MenuItemInitvalKey key);

    int insert(MenuItemInitval record);

    int insertSelective(MenuItemInitval record);

    List<MenuItemInitval> selectByExample(MenuItemInitvalExample example);

    MenuItemInitval selectByPrimaryKey(MenuItemInitvalKey key);

    int updateByExampleSelective(@Param("record") MenuItemInitval record, @Param("example") MenuItemInitvalExample example);

    int updateByExample(@Param("record") MenuItemInitval record, @Param("example") MenuItemInitvalExample example);

    int updateByPrimaryKeySelective(MenuItemInitval record);

    int updateByPrimaryKey(MenuItemInitval record);
}