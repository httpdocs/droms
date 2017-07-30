package com.droms.action;

import com.droms.dao.impl.AdminDaoImpl;
import com.droms.model.Admin;

public class AdminAction extends BaseAction {

	AdminDaoImpl dao = new AdminDaoImpl();
	
	@Override
	public String execute() throws Exception {
		System.out.println("=======修改用户=========");
		base();
		Admin newadmin = dao.findAdmin(username);
		newadmin.setName(admin.getName());
		newadmin.setPassword(admin.getPassword());
		dao.updateAdmin(newadmin);
		return SUCCESS;
	}
	
	public String exit(){
		System.out.println("============注销用户=================");
		base();
		admin  = dao.getAdmin(username);
		admin.setDromitory(null);
		dao.deleteAdmin(admin);
		return SUCCESS;
	}
}
