package com.demo.todo.service;

import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.http.response.RestResponse;

public interface TodoService {
    public RestResponse addUserTask(AddTaskDto task);

}
