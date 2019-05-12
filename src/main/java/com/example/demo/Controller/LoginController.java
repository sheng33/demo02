package com.example.demo.Controller;

import com.example.demo.Service.PersonService;
import com.example.demo.Service.UsersService;
import com.example.demo.domain.PersonMsg;
import com.example.demo.domain.Users;
import com.example.demo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UsersService usersService;      //登录服务
    @Autowired
    PersonService personService; //总信息服务
    @Autowired
    RedisUtil redisUtil;
//  登录页
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request){
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(session.getAttribute("User"));
        if(session.getAttribute("User")!=null){
            modelAndView.addObject("User",session.getAttribute("User"));
            modelAndView.setViewName("main");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

//  注册页
    @RequestMapping("/register")
    public String Register(){
        return "register";
    }
    @RequestMapping("Passwordrevise")
    public String Passwordrevise(){return "Passwordrevise";}

    @RequestMapping("/exit")
    public String Exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("User");
        redisUtil.remove("User");
        return "index";
    }

}
