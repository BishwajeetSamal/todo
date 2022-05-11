package com.demo.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TodoTask {
	@Id
	@GeneratedValue(generator = "task_generator")
	@SequenceGenerator(name = "task_generator", sequenceName = "task_sequence", initialValue = 1)
	private long id;
	private String taskrow;
	private int userId;
	private boolean isActive;
	private String emailId;
	private long deadLine;
	private long createdAt = System.currentTimeMillis();
	private long updateAt = System.currentTimeMillis();

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

	public long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(long deadLine) {
		this.deadLine = deadLine;
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

	public TodoTask(long id, String taskrow, int userId, boolean isActive, String emailId, long deadLine,
			long createdAt,
			long updateAt) {
		super();
		this.id = id;
		this.taskrow = taskrow;
		this.userId = userId;
		this.isActive = isActive;
		this.emailId = emailId;
		this.deadLine = deadLine;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public TodoTask() {
		super();
	}

	@Override
	public String toString() {
		return "TodoTask [id=" + id + ", taskrow=" + taskrow + ", userId=" + userId + ", isActive=" + isActive
				+ ", emailId=" + emailId + ", deadLine=" + deadLine + ", createdAt=" + createdAt + ", updateAt="
				+ updateAt
				+ "]";
	}

}
