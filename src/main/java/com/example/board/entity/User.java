package com.example.board.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected User() {}

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}