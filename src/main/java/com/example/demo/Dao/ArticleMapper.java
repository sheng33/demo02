package com.example.demo.Dao;

import com.example.demo.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Date;
import java.util.List;

public interface ArticleMapper {
    //显示所有文章
    @Select("select * from articlelist")
    List<Article> getAllArticle();
    //插入新文章
    @Insert("insert into articlelist(Author,Articlename,content,hitCount) " +
            "value(#{Author},#{Articlename},#{content},#{hitCount})")
    void saveArticle(@Param("Author") String Author,@Param("Articlename")  String Articlename,@Param("content")
                     String content,@Param("hitCount")  int hitCount);

    @Select("select * from articlelist where id = #{id}")
    Article queryArticle(@Param("id") int id);

    //更新文章点击数
    @Update("UPDATE articlelist SET  hitCount = #{hitCount} WHERE id = #{id} AND Author = #{Author}")
    void changeArticleHit(@Param("id")int id,@Param("Author")String Author,@Param("hitCount")int hitCount);

    //更新文章内容
    @Update("UPDATE articlelist SET" +
            "Articlename = #{Articlename},content = #{content},ChangTime = #{ChangTime} WHERE id = #{id} AND Author = #{Author}")
    void changeArticle(@Param("id")int id,
                       @Param("Author") String Author,@Param("Articlename")  String Articlename
                        ,@Param("content") String contentj,@Param("ChangTime") Date ChangTime);



}
