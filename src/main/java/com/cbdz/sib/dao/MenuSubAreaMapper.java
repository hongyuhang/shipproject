package com.cbdz.sib.dao;

import com.cbdz.sib.model.MenuSubArea;
import com.cbdz.sib.model.MenuSubAreaExample;
import com.cbdz.sib.model.MenuSubAreaKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuSubAreaMapper {
    long countByExample(MenuSubAreaExample example);

    int deleteByExample(MenuSubAreaExample example);

    int deleteByPrimaryKey(MenuSubAreaKey key);

    int insert(MenuSubArea record);

    int insertSelective(MenuSubArea record);

    List<MenuSubArea> selectByExample(MenuSubAreaExample example);

    MenuSubArea selectByPrimaryKey(MenuSubAreaKey key);

    int updateByExampleSelective(@Param("record") MenuSubArea record, @Param("example") MenuSubAreaExample example);

    int updateByExample(@Param("record") MenuSubArea record, @Param("example") MenuSubAreaExample example);

    int updateByPrimaryKeySelective(MenuSubArea record);

    int updateByPrimaryKey(MenuSubArea record);
}