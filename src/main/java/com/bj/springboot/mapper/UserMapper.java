package com.bj.springboot.mapper;

import com.bj.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by sunboyu on 2017/8/10.
 */
public interface UserMapper {

    @Select("select * from user")
    @Results(
            @Result(property = "username", column = "user_name")
    )
    List<User> getAll();

    @Select("select * from user where id = #{id}")
    @Results(
            @Result(property = "username", column = "user_name")
    )
    User getOne(Long id);

    @Insert("insert into user(user_name, password) values ( #{username}, #{password})")
    void insert(User user);

    @Delete("delete from user where id = #{id}")
    void delete(Long id);
}
