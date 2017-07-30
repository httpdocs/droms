package com.droms.service.impl;

import java.util.List;

import com.droms.action.BaseAction;
import com.droms.dao.AdminDao;
import com.droms.dao.impl.AdminDaoImpl;
import com.droms.model.Admin;
import com.droms.service.AdminService;

public class AdminServiceImpl extends BaseAction implements AdminService {
	
	private AdminDao admindao = new AdminDaoImpl();

	public boolean login(Admin admin) {
		if(!admindao.isExistByUserName(admin.getUsername())){
			System.out.println("该用户不存在");
			return false;
		}
		if(admindao.isTrueBypassword(admin)){
			Admin newAdmin = admindao.getAdmin(admin.getUsername());
			power = newAdmin.getDromitory().getId();
			//power = admindao.getPowerByAdmin(newAdmin);
			//保存进Session
			saveSession(newAdmin.getUsername(), power);
			return true;
		}
		System.out.println("密码不正确");
		return false;
	}

	public boolean regist(Admin admin) {
		int id = admin.getDromitory().getId();
		if(admindao.isExistByUserName(admin.getUsername())){
			System.out.println("该用户已存在");
			return false;
		}
		if(admindao.isExistByDromitory(id)){
			System.out.println("=======该楼管理员已存在，不能注册============");
			return false;
		}
		admindao.regist(admin);
		return true;
	}


	public List<Integer> findDromitory() {
		
		return admindao.findDromitory();
	}

}
