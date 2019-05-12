package com.example.demo.Dao;

import com.example.demo.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/*
*查询用户名功能    findUserByName
*注册账户功能 addUser
*登录功能   findLoginMsg
*/


public interface UsersMapper {
    @Select("select * from user where name=#{name}")
    Users findUserByName(@Param("name") String name);
    @Insert("insert into user(name,password,power) values( #{name},#{password},#{power})" )
    void addUser(@Param("name") String name,@Param("password")String password,@Param("power")int power);
    @Select("select * from user where name = #{name} and password = #{password}")
    Users findLoginMsg(@Param("name") String name,@Param("password") String password);

    @Update("update user SET password = #{Newpassword} WHERE name = #{name}")
    void revisePassword(@Param("name") String name,@Param("Newpassword") String Newpassword);

}
