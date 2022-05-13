package com.demo.todo.serviceImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.demo.todo.dto.AddTaskDto;
import com.demo.todo.dto.http.response.RestResponse;
import com.demo.todo.dto.http.response.StatusResponse;
import com.demo.todo.model.TodoTask;
import com.demo.todo.repository.TaskRepository;
import com.demo.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TaskRepository taskRepository;

    public RestResponse addUserTask(AddTaskDto task) {
        TodoTask compTask = new TodoTask();
        compTask.setEmailId(task.getEmailId());
        compTask.setTaskrow(task.getTaskrow());
        compTask.setUserId(task.getUserId());
        LocalDateTime dateTime = task.getUserTime();
        Timestamp timestamp_object = Timestamp.valueOf(dateTime);
        System.out.println("Time stamp : " + timestamp_object);
        System.out.println(timestamp_object.getTime());
        compTask.setDeadLine(timestamp_object.getTime());
        TodoTask obj = taskRepository.save(compTask);
        return new StatusResponse(200, "Task Created Successfully !", obj);
    }
}