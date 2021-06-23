package com.skypan.wbse.retrofit;

import java.util.List;

public class user {
    private String userId,password ;
    private List<String> userArticle;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserArticle(List<String> userArticle) {
        this.userArticle = userArticle;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getUserArticle() {
        return userArticle;
    }
}
