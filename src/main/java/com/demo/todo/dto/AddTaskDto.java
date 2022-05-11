package com.demo.todo.dto;

import java.time.LocalDateTime;

public class AddTaskDto {

	private String taskrow;
	private int userId;
	private boolean isActive;
	private String emailId;
	private LocalDateTime userTime;

	public String getTaskrow() {
		return taskrow;
	}
	public void setTaskrow(String taskrow) {
		this.taskrow = taskrow;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDateTime getUserTime() {
		return userTime;
	}
	public void setUserTime(LocalDateTime userTime) {
		this.userTime = userTime;
	}

	public AddTaskDto(String taskrow, int userId, boolean isActive, String emailId, LocalDateTime userTime) {
		super();
		this.taskrow = taskrow;
		this.userId = userId;
		this.isActive = isActive;
		this.emailId = emailId;
		this.userTime = userTime;
	
	}
	public AddTaskDto() {
		super();
	}

	@Override
	public String toString() {
		return "AddTaskDto [ taskrow=" + taskrow + ", userId=" + userId + ", isActive=" + isActive
				+ ", emailId=" + emailId + ", userTime=" + userTime + "]";
	}
	
	
}
