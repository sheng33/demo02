package com.example.demo.domain;

import java.util.Date;

public class Article {
    private int    id;
    private String Author;
    private String Articlename;
    private String content;
    private int    hitCount;
    private Date   UpdateTime;
    private Date   ChangeTime;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", Author='" + Author + '\'' +
                ", Articlename='" + Articlename + '\'' +
                ", content='" + content + '\'' +
                ", hitCount=" + hitCount +
                ", UpdateTime=" + UpdateTime +
                ", ChangeTime=" + ChangeTime +
                '}';
    }

    public String getArticlename() {
        return Articlename;
    }

    public void setArticlename(String articlename) {
        Articlename = articlename;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Date getChangeTime() {
        return ChangeTime;
    }

    public void setChangeTime(Date changeTime) {
        ChangeTime = changeTime;
    }

    /**
     * Gets the value of content.
     *
     * @return the value of content
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }
}


