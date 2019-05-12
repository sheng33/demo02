package com.example.demo.Controller;

import com.example.demo.Service.PersonService;
import com.example.demo.Service.UsersService;
import com.example.demo.Service.UsersServiceImpl;
import com.example.demo.domain.Person;
import com.example.demo.domain.PersonMsg;
import com.example.demo.domain.Users;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
* 本控制器负责三个页面
* 登录
* 注册
* main
*
*/


@MapperScan(basePackages = "com.example.demo.Dao")
@Controller
@SessionAttributes("User")      //全局传递登录用户session
public class UsersController {
    @Autowired
    UsersService usersService;      //登录服务
    @Autowired
    PersonService personService; //总信息服务

    // 注册功能
    @RequestMapping("/register1")
    public ModelAndView register(PersonMsg personMsg){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("控制"+personMsg);
        usersService.saveUser(personMsg);
        modelAndView.addObject("msg","<alert>注册成功</alert>");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/revisePassword")
    @ResponseBody
    public String revisePassword(String OldPassword, String NewPassword,@ModelAttribute("User") Users users){
        System.out.println("Users:"+users.getPassword()+"Old"+OldPassword+"Password"+NewPassword);
        if(users.getPassword().equals(OldPassword)){
            usersService.reviseUserPassword(users.getName(),NewPassword);
            return "修改成功";
        }else{
            return "修改失败";
        }


    }



    //登录功能
    @RequestMapping("main")
    public ModelAndView main(Users users, HttpServletRequest  request){
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        if(session.getAttribute("User")!=null){
            modelAndView.addObject("User",session.getAttribute("User"));
            modelAndView.setViewName("main");
            return modelAndView;
        }else{
            if(usersService.checkLogin(users.getName(),users.getPassword()) != null){
                modelAndView.addObject("name",users.getName());
                if(users.getPower() == 1){
                    modelAndView.addObject("power","超级管理员");
                }else{
                    modelAndView.addObject("power","资产管理员");
                }

                Person users1=personService.showUser(usersService.findUser(users.getName()).getId());
                session.setAttribute("User",users1);
                modelAndView.addObject("User",users1);
                modelAndView.setViewName("main");
                return modelAndView;
            }else{
                modelAndView.setViewName("error");
                return modelAndView;
            }
        }
    }



    //登录失败
    @RequestMapping("/loginError")
    @ResponseBody
    public String loginError(){
        return "登录失败";
    }

}
