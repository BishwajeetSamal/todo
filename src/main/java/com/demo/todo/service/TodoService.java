package com.demo.todo.service;

import java.util.List;
import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.model.TodoTask;

public interface TodoService {
    public RestResponse addUserTask(AddTaskDto task);

    public RestResponse fetchAllTasks(long userId);

}

