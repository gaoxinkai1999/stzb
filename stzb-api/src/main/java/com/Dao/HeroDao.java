package com.Dao;

import com.PoJo.HeroInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface HeroDao {
    @Select("select * from stzb.hero where name=#{name}")
    HeroInfo getHero(String name);
    @Select("select * from stzb.hero")
    ArrayList<HeroInfo> getAll();
}
