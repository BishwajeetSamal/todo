package com.demo.todo.service;
import javax.servlet.http.HttpServletRequest;

import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.UpdateRowDto;
import com.demo.todo.dto.http.response.RestResponse;

public interface TodoService {
    public RestResponse addUserTask(AddTaskDto task,long userId);
    public RestResponse fetchAllTasks(int offset,int pageSize,long userId);
     public RestResponse fetchTaskByText(int offset,int pageSize,String text,long userId);
     public RestResponse updateTaskRow(UpdateRowDto updateDto,long userId);
   

}

