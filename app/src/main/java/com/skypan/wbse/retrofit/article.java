package com.skypan.wbse.retrofit;

import java.util.List;

public class article {
    private String authorId,articleId,articleName,postTime,articleContent;
    private List<comment> comments;

    public void setComments(List<comment> comments) { this.comments = comments; }

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

    public List<comment> getComments() {return comments; }

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
}
