package com.lyw.query;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

public class TestQuery {
	public static void main(String args[]) {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		IdentityService is = engine.getIdentityService();
		
		Group group = is.newGroup("group001");
		group.setName("小组001");
		group.setType("type001");
		is.saveGroup(group);
		
	}
}
