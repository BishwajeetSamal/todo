package com.demo.todo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.todo.model.TodoTask;
import com.demo.todo.model.users.Users;
@Repository
public interface TaskRepository extends JpaRepository<TodoTask, Long>{
	 TodoTask findById(long id);
	 List<TodoTask> findByUsersOrderByCreatedAtDesc(Users u,Pageable pageable);
	 List<TodoTask> findByTaskrowContainingIgnoreCaseAndUsersOrderByCreatedAtDesc(String text,Users u,Pageable pageable);
	 long countByTaskrowContainingIgnoreCaseAndUsers(String str,Users userObj);
	 @Query("Select count(t) from TodoTask t where (t.users=?2) AND LOWER(t.taskrow) LIKE LOWER(CONCAT('%',?1, '%'))")
    int countByTaskrowContainingIgnoreCase( String searchVal,Users users);
	 long countByUsers(Users u);
	
	
}
