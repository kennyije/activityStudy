package com.example;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

public class FirstAct {
	public static void main(String[] args) {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		//部署流程到数据库中
		RepositoryService rs = engine.getRepositoryService();
		
		RuntimeService runService =  engine.getRuntimeService();
		
		TaskService taskService = engine.getTaskService();
		
		rs.createDeployment().addClasspathResource("askforleave.bpmn").deploy();
		
		ProcessInstance pi = runService.startProcessInstanceByKey("myProcess");
		
		//员工任务
		Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		System.out.println("当前节点 "+ task.getName());
		taskService.complete(task.getId());
		
		task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		System.out.println("当前节点" + task.getName());
		taskService.complete(task.getId());
		
		task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
		System.out.println("当前任务" + task);
		
		engine.close();
		System.exit(0);
	}
}
