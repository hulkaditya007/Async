package com.async.async;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskModel {

	@Id
	private String taskId;
	private String status;
	private String taskOutput;
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTaskOutput() {
		return taskOutput;
	}
	public void setTaskOutput(String taskOutput) {
		this.taskOutput = taskOutput;
	}
	
	
	
	public TaskModel() {}
	
	public TaskModel(String status, String taskOutput) {
		super();
		this.status = status;
		this.taskOutput = taskOutput;
	}
	
	
	
	
}
