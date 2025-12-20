package com.example.board.entity;


import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="posts")
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private int viewCount;

    protected Post() {}

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.viewCount = 0;
    }
}
