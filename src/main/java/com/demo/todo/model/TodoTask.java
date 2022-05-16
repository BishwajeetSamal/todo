package com.demo.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.demo.todo.model.users.Users;


@Entity
public class TodoTask {
	@Id
	@GeneratedValue(generator = "task_generator")
	@SequenceGenerator(name = "task_generator", sequenceName = "task_sequence", initialValue = 1)
	private long id;
	private String taskrow;
	private boolean isActive;
	@Column(columnDefinition="TEXT")
	private String description;
	private long deadLine;
	private long createdAt = System.currentTimeMillis();
	private long updateAt = System.currentTimeMillis();
	
	@ManyToOne
	Users users;

	public TodoTask(long id, String taskrow, boolean isActive, String description, long deadLine, long createdAt,
			long updateAt, Users users) {
		this.id = id;
		this.taskrow = taskrow;
		this.isActive = isActive;
		this.description = description;
		this.deadLine = deadLine;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.users = users;
	}

	public TodoTask() {
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "TodoTask [createdAt=" + createdAt + ", deadLine=" + deadLine + ", description=" + description + ", id="
				+ id + ", isActive=" + isActive + ", taskrow=" + taskrow + ", updateAt=" + updateAt + ", users=" + users
				+ "]";
	}
	
	
	
}
