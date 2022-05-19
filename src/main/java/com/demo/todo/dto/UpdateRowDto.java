package com.demo.todo.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.demo.todo.model.users.Users;

public class UpdateRowDto {
    @NotNull(message = "Id required")
    private long id;
    private String taskrow;
	private String description;
	private LocalDateTime userTime;
	private long updateAt = System.currentTimeMillis();

	Users users;

    public UpdateRowDto(@NotNull(message = "Id required") long id, String taskrow, String description,
            LocalDateTime userTime, long updateAt, Users users) {
        this.id = id;
        this.taskrow = taskrow;
        this.description = description;
        this.userTime = userTime;
        this.updateAt = updateAt;
        this.users = users;
    }

    public UpdateRowDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskrow() {
        return taskrow;
    }

    public void setTaskrow(String taskrow) {
        this.taskrow = taskrow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUserTime() {
        return userTime;
    }

    public void setUserTime(LocalDateTime userTime) {
        this.userTime = userTime;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UpdateRowDto [description=" + description + ", id=" + id + ", taskrow=" + taskrow + ", updateAt="
                + updateAt + ", userTime=" + userTime + ", users=" + users + "]";
    }

   
    
    
}
