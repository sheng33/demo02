package com.example.demo.Controller;



import java.util.List;

import com.example.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Service.ArticleServiceImpl;
import com.example.demo.domain.Article;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ArticleController {
    @Autowired
    ArticleServiceImpl articleService;
    @RequestMapping("/editor")
    public String openEditor(){
        return "editor";
    }


    @RequestMapping("/saveArticle")
    @ResponseBody
    public ModelAndView saveArticle(Article article, HttpSession session) {

        Person person = (Person)session.getAttribute("User");
        articleService.saveAritcle(person.getName(),article.getArticlename(),
                                   article.getContent(),0);
        int id = articleService.showALlArticle().size();
        System.out.println("number"+id);
        ModelAndView modelAndView = new ModelAndView();
        Article Artic = articleService.queryArticleId(id);
        System.out.println("控制层"+Artic);
        modelAndView.addObject("Artic", Artic);
        modelAndView.setViewName("ArticleDetail");
        return modelAndView;
    }

    @RequestMapping("item/{id}")
    @ResponseBody
    public ModelAndView queryArticleId(@PathVariable() int id){
        ModelAndView modelAndView = new ModelAndView();
        Article Artic = articleService.queryArticleId(id);
        System.out.println("控制层"+Artic);
        modelAndView.addObject("Artic", Artic);
        modelAndView.setViewName("ArticleDetail");

        return modelAndView;
    }


    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("/showAllArticle")
    public String showAllArticle(Model model) {
        List<Article> articleList = articleService.showALlArticle();

        System.out.println(articleList);
        model.addAttribute("articleList", articleList);

        return "AllArticle";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
