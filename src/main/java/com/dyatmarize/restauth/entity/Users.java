package com.dyatmarize.restauth.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String passwordHash;
    private Instant createdAt;
    private Instant updatedAt;
}
