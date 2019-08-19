package com.learn.majiang.mapper;

import com.learn.majiang.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

  @Options(useGeneratedKeys = true,keyProperty = "id")
  @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified,bio,avatarUrl) values (#{account_id},#{name},#{token},#{gmt_create},#{gmt_modified},#{bio},#{avatarUrl})")
  void insert(User user);

  @Select("select * from user where token=#{token}")
  User findByToken(@Param("token") String token);


  @Delete("delete from user where id=#{id}")
  void deleteUser(@Param("id") Integer id);

  @Select("select * from user where id=#{id}")
  User findUserById(@Param("id") Integer id);
}
