package com.example.demo.Service;

import com.example.demo.domain.PersonMsg;
import com.example.demo.domain.Users;

public interface UsersService {
    Users findUser(String name);
    void saveUser(PersonMsg personMsg);
    Users checkLogin(String name,String password);
    void reviseUserPassword(String name,String Newpassword);
}
