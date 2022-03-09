package com.async.async;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.async.async.service.AsyncService;

@RestController
public class AsyncController {
	
	@Autowired
	AsyncService asyncService;

	
	@PostMapping("/CreateTask")
	public TaskModel createTask() throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName());
		TaskModel taskModel = new TaskModel();
		taskModel.setTaskId(UUID.randomUUID().toString());
		taskModel.setStatus("Inprogress");
		taskModel.setTaskOutput("");
		asyncService.asyncRepositorySave(taskModel);
		return taskModel;
	}
	
	@GetMapping("/PollingTask/{taskId}")
	public TaskModel getTask(@PathVariable String taskId)
	{
		return asyncService.asyncRepositoryGet(taskId);
	}
}
