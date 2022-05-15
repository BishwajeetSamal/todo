package com.demo.todo.dto;

import java.time.LocalDateTime;

public class AddTaskDto {

	private String taskrow;
	private long userId;
	private boolean isActive;
	private String emailId;
	private LocalDateTime userTime;
	
	public AddTaskDto(String taskrow, long userId, boolean isActive, String emailId, LocalDateTime userTime) {
		this.taskrow = taskrow;
		this.userId = userId;
		this.isActive = isActive;
		this.emailId = emailId;
		this.userTime = userTime;
	}

	public AddTaskDto() {
	}

	public String getTaskrow() {
		return taskrow;
	}

	public void setTaskrow(String taskrow) {
		this.taskrow = taskrow;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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

	@Override
	public String toString() {
		return "AddTaskDto [emailId=" + emailId + ", isActive=" + isActive + ", taskrow=" + taskrow + ", userId="
				+ userId + ", userTime=" + userTime + "]";
	}

	
	
	
}
