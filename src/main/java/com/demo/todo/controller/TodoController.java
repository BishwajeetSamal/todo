package com.demo.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.dto.http.response.StatusResponse;
import com.demo.todo.model.TodoTask;
import com.demo.todo.repository.TaskRepository;
import com.demo.todo.service.TodoService;

@RestController
@RequestMapping("/api/v1/")
public class TodoController {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TodoService todoService;

	@GetMapping("alltasks/showall/{offset}/{pageSize}")
	public RestResponse getAllTasks(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize,
			HttpServletRequest req) {
		long userId = Long.parseLong(req.getAttribute("id").toString());
		return todoService.fetchAllTasks(offset, pageSize, userId);

	}

	@PostMapping("/alltasks")
	// create task rest Api
	public RestResponse createTask(@RequestBody AddTaskDto task) {
		try {
			return todoService.addUserTask(task);
		} catch (Exception e) {
			return new StatusResponse(500, e.getMessage(), null);
		}
	}

	// update employee rest API
	@PutMapping("/alltasks/{id}")
	public TodoTask updateIsActiveTask(@PathVariable long id) {
		TodoTask task = taskRepository.findById(id);
		if (task != null) {
			task.setActive(true);
			return taskRepository.save(task);
		} else
			return null;
		// return ResponseEntity.ok(updateEmployee);

	}

}
