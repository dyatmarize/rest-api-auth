package com.dyatmarize.restauth.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "blog_posts")
public class BlogPosts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Integer authorId;
    private Instant createdAt;
    private Instant updatedAt;
}
