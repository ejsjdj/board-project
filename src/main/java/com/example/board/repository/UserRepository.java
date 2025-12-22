package com.example.board.repository;

import com.example.board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    <Optional>User findByUsername(String username);
    User findByEmail(String email);
    boolean existsByUsername(String username);

}
