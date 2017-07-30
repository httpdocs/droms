package com.droms.action;

import com.droms.service.AdminService;
import com.droms.service.impl.AdminServiceImpl;

public class RegistAction extends BaseAction {

	private AdminService adminService = new AdminServiceImpl();
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("==========注册==========");
		return adminService.regist(admin)? SUCCESS : ERROR;
	}
	
	
}
