package com.droms.action;

import com.droms.service.AdminService;
import com.droms.service.impl.AdminServiceImpl;

public class LoginAction extends BaseAction{

	private AdminService adminService = new AdminServiceImpl();
	
	@Override
	public String execute() throws Exception {
		System.out.println("============登录=================");
		
		if(adminService.login(admin)){
			return SUCCESS;
		}
		return ERROR;	
	}
}
