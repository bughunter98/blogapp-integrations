package com.springboot.blog.blogrestapi.pojos;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class PostDto {
    private long id;
    @NotEmpty // title should not be empty
    @Size(min = 3 , message = "Post Title should have atleast 3 characters")
    private String title;
    @NotEmpty
    @Size(min = 10 , message = "Post Description should atleast have 10 characters")
    private String description;
    @NotEmpty(message = "must not be empty")
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
