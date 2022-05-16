package com.demo.todo.dto;

import java.time.LocalDateTime;

import com.demo.todo.model.users.Users;

public class AddTaskDto {

	private String taskrow;
	private boolean isActive;
	private String description;
	private LocalDateTime userTime;
	private long createdAt = System.currentTimeMillis();
	private long updateAt = System.currentTimeMillis();

	Users users;

	public AddTaskDto(String taskrow, boolean isActive, String description, LocalDateTime userTime, long createdAt,
			long updateAt, Users users) {
		this.taskrow = taskrow;
		this.isActive = isActive;
		this.description = description;
		this.userTime = userTime;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.users = users;
	}

	public AddTaskDto() {
	}

	public String getTaskrow() {
		return taskrow;
	}

	public void setTaskrow(String taskrow) {
		this.taskrow = taskrow;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
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
		return "AddTaskDto [createdAt=" + createdAt + ", description=" + description + ", isActive=" + isActive
				+ ", taskrow=" + taskrow + ", updateAt=" + updateAt + ", userTime=" + userTime + ", users=" + users
				+ "]";
	}
}

	