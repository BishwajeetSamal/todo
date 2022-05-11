package com.demo.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.model.TodoTask;
@Repository
public interface TaskRepository extends JpaRepository<TodoTask, Long>{
	public TodoTask findById(long id);
	public List<TodoTask> findAll();
	
}
