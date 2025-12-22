package com.example.board.repository;

import com.example.board.entity.Post;
import com.example.board.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUser(User user, Pageable pageable);

    Page<Post> findByTitleContaining(String keyword, Pageable pageable);
}