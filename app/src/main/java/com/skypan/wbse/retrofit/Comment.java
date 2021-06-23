package com.skypan.wbse.retrofit;

public class Comment {
    private String reviewerId,postTime,commentContent;


    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public String getPostTime() {
        return postTime;
    }

    public String getCommentContent() {
        return commentContent;
    }
}
