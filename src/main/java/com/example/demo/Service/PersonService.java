package com.example.demo.Service;

import com.example.demo.domain.Person;

public interface PersonService {
    Person showUser(int id);
    void SavePersonMsg(Person person);
}
