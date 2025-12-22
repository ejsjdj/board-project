package com.example.board.repository;

import com.example.board.entity.Comment;
import com.example.board.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByPostAndParentCommentIsNull(Post post, Pageable pageable);

    List<Comment> findByParentComment(Comment parentComment);
}