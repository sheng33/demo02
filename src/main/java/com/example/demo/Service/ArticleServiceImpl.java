package com.example.demo.Service;

import com.example.demo.Dao.ArticleMapper;
import com.example.demo.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    //显示所有文章
    @Override
    public List<Article> showALlArticle() {
        return articleMapper.getAllArticle();
    }

    /**
     *
     * @Author 作者
     * @Articlename  文章名
     * @content    文章内容
     * @hitCount    点击率
     */
    //保存文章
    @Override
    public void saveAritcle(String Author, String Articlename, String content,int hitCount) {
        articleMapper.saveArticle(Author,Articlename,content,0);
    }
    //更新文章
    @Override
    public void updateArticle(int id, String Author, String Articlename, String content,Date ChangTime) {
        articleMapper.changeArticle(id,Author,Articlename,content,ChangTime);
    }

    //查询单个文章
    @Override
    public Article queryArticleId(int id) {
        Article article = articleMapper.queryArticle(id);
        articleMapper.changeArticleHit(article.getId(),article.getAuthor(),article.getHitCount()+1);
        article = articleMapper.queryArticle(id);
        return article;
    }
}
