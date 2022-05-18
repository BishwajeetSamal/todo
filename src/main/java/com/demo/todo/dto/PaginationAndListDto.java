package com.demo.todo.dto;

import java.util.List;

import com.demo.todo.model.TodoTask;


public class PaginationAndListDto {
    private int count;
    private List<TodoTask> tasks;
    public PaginationAndListDto(int count, List<TodoTask> tasks) {
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
