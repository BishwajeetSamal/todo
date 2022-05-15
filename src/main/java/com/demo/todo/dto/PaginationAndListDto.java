package com.demo.todo.dto;

import com.demo.todo.model.TodoTask;

import org.springframework.data.domain.Page;

public class PaginationAndListDto {
    private int count;
    private Page<TodoTask> tasks;

    public PaginationAndListDto(int count, Page<TodoTask> tasks) {
        this.count = count;
        this.tasks = tasks;
    }

    public PaginationAndListDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page<TodoTask> getTasks() {
        return tasks;
    }

    public void setTasks(Page<TodoTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "PaginationAndListDto [count=" + count + ", tasks=" + tasks + "]";
    }

    

    
    
}
