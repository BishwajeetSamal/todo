package com.demo.todo.dto;

import java.util.List;

import com.demo.todo.model.TodoTask;


public class PaginationAndListDto {
    private long count;
    private List<TodoTask> tasks;
    public PaginationAndListDto(int count, List<TodoTask> tasks) {
        this.count = count;
        this.tasks = tasks;
    }

    public PaginationAndListDto() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<TodoTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<TodoTask> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "PaginationAndListDto [count=" + count + ", tasks=" + tasks + "]";
    }

   
    

    
    
}
