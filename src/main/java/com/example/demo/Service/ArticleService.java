package com.example.demo.Service;

import com.example.demo.domain.Article;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ArticleService {
    List<Article> showALlArticle();
    void saveAritcle(String Author,String Articlename,String content,int hitCount);
    void updateArticle(int id,String Author,String Articlename,String content,Date ChangTime);
    Article queryArticleId(int id);
}
