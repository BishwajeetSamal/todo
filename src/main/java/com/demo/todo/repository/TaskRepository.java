package com.demo.todo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.model.TodoTask;
import com.demo.todo.model.users.Users;
@Repository
public interface TaskRepository extends JpaRepository<TodoTask, Long>{
	public TodoTask findById(long id);
	public List<TodoTask> findByUsersOrderByCreatedAtDesc(Users u,Pageable pageable);
	public List<TodoTask> findByTaskrowContainingIgnoreCaseAndUsersOrderByCreatedAtDesc(String text,Users u,Pageable pageable);
	public long countByTaskrowContainingIgnoreCaseAndUsers(String str,Users userObj);
	public long countByUsers(Users u);
	
	
}
