package com.springboot.blog.blogrestapi.pojos;

public class CommentDto {
    private long id;
    private String userName;
    private String emailId;
    private String body;

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
