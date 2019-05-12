package com.example.demo.Controller;

import com.example.demo.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@SessionAttributes("mailCode")
@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/sendMail")
    @ResponseBody
    public String sendSimpleEmail(String mail){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        ModelAndView model = new ModelAndView();
        model.addObject("mailCode",result);
        System.out.println("验证码"+result);
        emailService.sendSimpleMail("mail","验证码",result);
        return "success";
    }

    @RequestMapping("yzmailCode")
    public String yzmailCode(String code,@ModelAttribute("mailCode") String yzcode){
        if(code.equals(yzcode)) {
            return "/register1";
        }else {
            return "/error";
        }
    }
}
