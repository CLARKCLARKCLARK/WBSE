package com.skypan.wbse.retrofit;

public class articleComment {
    private String reviewerId;
    private String postTime;
    private String commentContent;
    private String id;

    public articleComment(String reviewerId,String postTime,String commentContent,String id){
        this.reviewerId=reviewerId;
        this.postTime=postTime;
        this.commentContent = commentContent;
        this.id = id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public String getReviewerId() {
        return reviewerId;
    }

    public String getPostTime() {
        return postTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    @Override
    public String toString() {
        return "Event{" +
                reviewerId+postTime+commentContent+
                '}';
    }
}
