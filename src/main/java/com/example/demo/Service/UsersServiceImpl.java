package com.example.demo.Service;

import com.example.demo.Dao.PersonMapper;
import com.example.demo.Dao.UsersMapper;
import com.example.demo.domain.Person;
import com.example.demo.domain.PersonMsg;
import com.example.demo.domain.Users;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;
    @Resource
    PersonMapper personMapper;


    @Override
    public Users findUser(String name) {
        return usersMapper.findUserByName(name);
    }

    @Override
    public void saveUser(PersonMsg personMsg) {
        System.out.println(personMsg);
        if(personMsg.getPower() == 1){
            personMsg.setZhiwei("超级管理员");
        }else{
            personMsg.setZhiwei("资产管理员");
        }
        System.out.println(personMsg.getBirth());
        Calendar c = Calendar.getInstance();
        int newYear = c.get(Calendar.YEAR);
        c.setTime(personMsg.getBirth());
        int personYear = c.get(Calendar.YEAR);
        System.out.println("newYear" + newYear+"personYear"+personYear);
        personMsg.setAge(newYear-personYear+1);
        usersMapper.addUser(personMsg.getIdname(),personMsg.getPassword(),personMsg.getPower());
        personMapper.SaveMsg(personMsg.getName(),personMsg.getBirth(),personMsg.getAge(),personMsg.getZhiwei());
    }

    @Override
    public Users checkLogin(String name, String password) {
        return usersMapper.findLoginMsg(name,password);
    }

    @Override
    public void reviseUserPassword(String name,String Newpassword) {
            usersMapper.revisePassword(name,Newpassword);
    }
}
