package com.example.demo.Dao;

import com.example.demo.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

/*
*显示账户信息 showMsg
*保存账户信息 SaveMsg
*/
public interface PersonMapper {
    @Select("select * from person where id=#{id}")
    Person showMsg(@Param("id") int id);
    @Insert("insert into person(id,name,birth,age,zhiwei) values(null, #{name},#{birth},#{age},#{zhiwei})")
    void SaveMsg(@Param("name") String name, @Param("birth")Date birth,@Param("age") int age,@Param("zhiwei") String zhiwei);
}
