package com.skypan.wbse.retrofit;

import java.util.ArrayList;

public class Article {
    private String authorId,articleId,articleName,postTime,articleContent;
    private ArrayList<articleComment> articleComments;



    public void setArticleComments(ArrayList<articleComment> articleComments) { this.articleComments = articleComments; }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public ArrayList<articleComment> getArticleComments() {return articleComments; }

    public String getAuthorId() {
        return authorId;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getPostTime() {
        return postTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    @Override
    public String toString() {
        return "Event{" +
                authorId+articleId+articleName+postTime+articleContent+
                '}';
    }
}
