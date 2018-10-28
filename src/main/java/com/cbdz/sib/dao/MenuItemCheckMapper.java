package com.cbdz.sib.dao;

import com.cbdz.sib.model.MenuItemCheck;
import com.cbdz.sib.model.MenuItemCheckExample;
import com.cbdz.sib.model.MenuItemCheckKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuItemCheckMapper {
    long countByExample(MenuItemCheckExample example);

    int deleteByExample(MenuItemCheckExample example);

    int deleteByPrimaryKey(MenuItemCheckKey key);

    int insert(MenuItemCheck record);

    int insertSelective(MenuItemCheck record);

    List<MenuItemCheck> selectByExample(MenuItemCheckExample example);

    MenuItemCheck selectByPrimaryKey(MenuItemCheckKey key);

    int updateByExampleSelective(@Param("record") MenuItemCheck record, @Param("example") MenuItemCheckExample example);

    int updateByExample(@Param("record") MenuItemCheck record, @Param("example") MenuItemCheckExample example);

    int updateByPrimaryKeySelective(MenuItemCheck record);

    int updateByPrimaryKey(MenuItemCheck record);
}