package com.springboot.blog.blogrestapi.pojos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CommentDto {
    private long id;
    @NotEmpty(message = "User Name should not be null or empty")
    private String userName;
    @Email
    @NotEmpty(message = "email cannot be empty")
    private String emailId;
    @NotEmpty
    @Size(min = 10 , message = "comment should have minimum 10 characters")
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
