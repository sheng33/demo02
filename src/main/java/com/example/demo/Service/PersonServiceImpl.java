package com.example.demo.Service;

import com.example.demo.Dao.PersonMapper;
import com.example.demo.domain.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    PersonMapper personMapper;

    @Override
    public Person showUser(int id) {
        return personMapper.showMsg(id);
    }

    @Override
    public void SavePersonMsg(Person person) {
        personMapper.SaveMsg(person.getName(),person.getBirth(),person.getAge(),person.getZhiwei());
    }
}
