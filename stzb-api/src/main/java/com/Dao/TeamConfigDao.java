package com.Dao;

import com.PoJo.TeamConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface TeamConfigDao {
    @Select("select * from stzb.阵容预设 where id=#{id}")
    ArrayList<TeamConfig> selectall(String id);
    @Select("select * from stzb.阵容预设 where id=#{id} and 阵容名=#{阵容名}")
    TeamConfig select(String id,String 阵容名);
    @Insert("insert into stzb.阵容预设 values (#{id},#{阵容名},#{阵容配置})")
    void add(TeamConfig teamConfig);

}
