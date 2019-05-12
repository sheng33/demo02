package com.example.demo.Controller;

import com.example.demo.Service.PersonService;
import com.example.demo.domain.Person;
import com.example.demo.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/*
 * 本控制器负责1个页面
 * 个人信息
 *
 *
 *
 */
@Controller
@SessionAttributes("User")
public class PersonController {
    @Autowired
    PersonService personService;        //个人信息服务

    //个人信息详情
    @RequestMapping("person")
    public ModelAndView showperson(@ModelAttribute("User") Person users){
        ModelAndView modelAndView = new ModelAndView();
        Person person = personService.showUser(users.getId());
        modelAndView.addObject("name",person.getName());
        modelAndView.addObject("birth",person.getBirth());
        modelAndView.addObject("age",person.getAge());
        modelAndView.addObject("zhiwei",person.getZhiwei());
        return modelAndView;
    }

}
