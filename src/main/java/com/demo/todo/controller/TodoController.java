package com.demo.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.model.TodoTask;
import com.demo.todo.repository.TaskRepository;
@RestController
@RequestMapping("/api/v1/")
public class TodoController {
		@Autowired
		private TaskRepository taskRepository;
		
		@GetMapping("alltasks/showall")
		public List<TodoTask> getAllTasks(){
			return taskRepository.findAll();
			
		}
		
		@PostMapping("/alltasks")
		//create task rest Api
		public TodoTask createTask(@RequestBody AddTaskDto task) {
			System.out.println(task);
			TodoTask compTask = new TodoTask();
			compTask.setEmailId(task.getEmailId());
			compTask.setTaskrow(task.getTaskrow());
			compTask.setUserId(task.getUserId());
			LocalDateTime dateTime =task.getUserTime();
	        Timestamp timestamp_object = Timestamp.valueOf(dateTime);
	        System.out.println("Time stamp : " + timestamp_object);
	        System.out.println(timestamp_object.getTime());
			compTask.setDeadLine(timestamp_object.getTime());
			
	        return taskRepository.save(compTask);
		}
		
		//update employee rest API
		@PutMapping("/alltasks/{id}")
		public TodoTask updateIsActiveTask(@PathVariable long id){
			System.out.println("id");
			System.out.println(id);
			TodoTask task = taskRepository.findById(id);
			if(task!=null)
			{
				task.setActive(true);
				return taskRepository.save(task);
			}
			else return null;
			//return ResponseEntity.ok(updateEmployee);
			
			
		}
	
}
