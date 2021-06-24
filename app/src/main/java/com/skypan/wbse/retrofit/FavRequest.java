package com.skypan.wbse.retrofit;

import java.util.List;

public class FavRequest {
    private String userId ;
    private String articleId;

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public void setArticleId(String userArticle) {
        this.articleId = userArticle;
    }

    public String getUserId() {
        return userId;
    }

    public String getArticleId() {
        return articleId;
    }
}
