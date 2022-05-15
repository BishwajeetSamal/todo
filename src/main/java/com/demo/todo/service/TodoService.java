package com.demo.todo.service;
import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.http.response.RestResponse;

public interface TodoService {
    public RestResponse addUserTask(AddTaskDto task);
    public RestResponse fetchAllTasks(int offset,int pageSize,long userId);
     public RestResponse fetchTaskByText(int offset,int pageSize,String text,long userId);
   

}

