package com.droms.form;

import java.util.ArrayList;
import java.util.List;

import com.droms.action.BaseAction;
import com.droms.service.AdminService;
import com.droms.service.impl.AdminServiceImpl;

public class RegistForm extends BaseAction {

	private AdminService service = new AdminServiceImpl();
	
	private List<Integer> list = new ArrayList<Integer>();
	
	
	@Override
	public String execute() throws Exception {
		list = service.findDromitory();
		return SUCCESS;
	}


	public List<Integer> getList() {
		return list;
	}


	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	
}
