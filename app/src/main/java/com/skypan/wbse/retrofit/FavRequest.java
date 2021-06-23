package com.skypan.wbse.retrofit;

import java.util.List;

public class FavRequest {
    private String userId ;
    private List<String> articleId;

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void setArticleId(List<String> userArticle) {
        this.articleId = userArticle;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getArticleId() {
        return articleId;
    }
}
