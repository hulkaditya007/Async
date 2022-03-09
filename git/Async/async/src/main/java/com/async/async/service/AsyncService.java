package com.async.async.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.async.async.AsyncController;
import com.async.async.AsyncRepository;
import com.async.async.TaskModel;

@Service
public class AsyncService{

	@Autowired
	AsyncRepository asyncRepository;
	
	
	@Async
	public void asyncRepositorySave(TaskModel taskModel) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName());
		TaskModel result = asyncRepository.saveAndFlush(taskModel);
		Thread.sleep(30000);
		result.setStatus("Completed");
		result.setTaskOutput("Task is complete");
		asyncRepository.saveAndFlush(result);
	}
	
	public TaskModel asyncRepositoryGet(String taskId)
	{
		return asyncRepository.findById(taskId).get();
	}

}
