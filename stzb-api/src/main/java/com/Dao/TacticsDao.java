package com.Dao;

import com.PoJo.TacticInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface TacticsDao {
    @Select("select * from stzb.tactics")
    ArrayList<TacticInfo> getAll();
}
