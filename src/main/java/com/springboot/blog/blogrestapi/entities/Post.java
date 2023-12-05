package com.springboot.blog.blogrestapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts"/*uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}*/)
public class Post {
    @Id
    @Column(name = "id",nullable = false)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "content", nullable = false)
    private String content;
}

/*
* public class Post extends org.example.model.Post {
}*/
