package com.demo.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.UpdateRowDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.dto.http.response.StatusResponse;
import com.demo.todo.service.TodoService;

@RestController
@RequestMapping("/api/v1/")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("alltasks/showall/{offset}/{pageSize}")
	public RestResponse getAllTasks(@PathVariable("offset") int offset, @PathVariable("pageSize") int pageSize,
			HttpServletRequest req) {
				try {
					long userId = Long.parseLong(req.getAttribute("id").toString());
					return todoService.fetchAllTasks(offset, pageSize, userId);
				} catch (Exception e) {
					return new StatusResponse(500, e.getMessage(), null);
				}
		
	}

	@PostMapping("/alltasks")
	// create task rest Api
	public RestResponse createTask(@RequestBody AddTaskDto task,HttpServletRequest req) {
		try {
			long userId = Long.parseLong(req.getAttribute("id").toString());
			return todoService.addUserTask(task,userId);
		} catch (Exception e) {
			return new StatusResponse(500, e.getMessage(), null);
		}
	}

	// update employee rest API
	@PutMapping("/alltasks/{id}")
	public RestResponse updateIsActiveTask(@PathVariable long id) {
		try {
			return todoService.checkUncheckTask(id);
		} catch (Exception e) {
			return new StatusResponse(500, e.getMessage(), null);
		}
		

	}

	
	@GetMapping("alltasks/searchall")
	public RestResponse textSearchAll(@RequestParam(defaultValue = "1",required = false)int pageNumber, @RequestParam(required = false,defaultValue = "4")int pageData, @RequestParam(defaultValue ="",required = false)String textSearch,
			HttpServletRequest req) {
		try {
			long userId = Long.parseLong(req.getAttribute("id").toString());
		return todoService.fetchTaskByText(pageNumber, pageData,textSearch,userId);
		} catch (Exception e) {
			return new StatusResponse(500, e.getMessage(), null);
		}
	}

	// update employee rest API
	@PutMapping("alltasks/updatetask")
	public RestResponse updateRowTsk(@RequestBody UpdateRowDto updateDto,HttpServletRequest req) {	
		try {
			long userId = Long.parseLong(req.getAttribute("id").toString());
			
		return todoService.updateTaskRow(updateDto,userId);
		} catch (Exception e) {
			return new StatusResponse(500, e.getMessage(), null);
		}

	}
}
