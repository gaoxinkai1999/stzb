package com.Dao;

import com.PoJo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from stzb.user where id=#{id}")
    User get(String id);
    @Insert("insert into stzb.user values (#{id},#{username})")
    void add(String id,String username);

}
