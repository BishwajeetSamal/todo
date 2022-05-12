package com.demo.todo.repository;

import com.demo.todo.model.users.Token;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TokenRepository
 */
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByUserId(long id);
}
