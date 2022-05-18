package com.demo.todo.repository;

import com.demo.todo.model.users.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailIdIgnoreCase(String emailId);

    Users findByUserName(String userName);
    Users findById(long userId);

    Users findByUserNameIgnoreCase(String userName);


}
