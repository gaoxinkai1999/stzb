package com.Dao;

import com.PoJo.开荒预设;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface 开荒预设Dao {
    @Insert("insert into stzb.开荒预设 values (#{赛季类型},#{土地等级},#{阵容名},#{阵容配置})")
    void add(开荒预设 预设);
    @Select("select * from stzb.开荒预设 ")
    ArrayList<开荒预设> getall();
}
