package com.skypan.wbse.retrofit;

public class comment {
    private String commentId,reviewerId,postTime,commentContent;

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentId() {
        return commentId;
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
