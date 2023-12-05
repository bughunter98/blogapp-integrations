package com.springboot.blog.blogrestapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id",nullable = false)
    private long id;
    @Column(name = "userName",nullable = false)
    private String userName;
    @Column(name = "emailId",nullable = false)
    private String emailId;
    @Column(name = "body",nullable = false)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id",nullable = false)
    private Post post;
}
