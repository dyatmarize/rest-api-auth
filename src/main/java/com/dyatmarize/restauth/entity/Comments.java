package com.dyatmarize.restauth.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer postId;
    private String authorName;
    private String content;
    private Instant createdAt;
}
