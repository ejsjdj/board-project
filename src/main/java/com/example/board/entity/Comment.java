package com.example.board.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id", nullable = true)
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", fetch = FetchType.LAZY)
    private List<Comment> replies = new ArrayList<>();

    @Column(updatable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Comment(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 대댓글 생성
    public Comment(String content, Post post, User user, Comment parentComment) {
        this.content = content;
        this.post = post;
        this.user = user;
        this.parentComment = parentComment;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // 내용 수정 (권한 체크 포함)
    public void updateContent(String newContent, User requestUser) {
        if (!this.user.getId().equals(requestUser.getId())) {
            throw new IllegalArgumentException("작성자만 수정할 수 있습니다");
        }
        this.content = newContent;
        this.updatedAt = LocalDateTime.now();
    }
}
