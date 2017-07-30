package com.droms.form;

import java.util.ArrayList;
import java.util.List;

import com.droms.action.BaseAction;
import com.droms.model.Dromitory;
import com.droms.service.DromitoryService;
import com.droms.service.impl.DromitoryServiceImpl;

public class DromitoryForm extends BaseAction {

	private DromitoryService service  = new DromitoryServiceImpl();
	
	private List<Dromitory> list = new ArrayList<Dromitory>();
	
	private Dromitory dromitory;
	
	
	/**
	 * 宿舍楼信息 页面
	 * @return
	 */
	public String listForm(){
		//获取session中的username 和 power
		base();
		setList(service.findDromitoryByPower(power));
		return SUCCESS;
	}
	/**
	 * 添加宿舍楼 页面
	 * @return
	 */
	public String addForm(){
		base();
		return power == 0 ? SUCCESS : INPUT;
	}
	/**
	 * 修改宿舍楼信息 页面
	 * @return
	 */
	public String updateForm(){
		base();
		dromitory = service.findDromitory(dromitory.getId());
		return power == 0 ? SUCCESS : INPUT;
	}
	public List<Dromitory> getList() {
		return list;
	}
	public void setList(List<Dromitory> list) {
		this.list = list;
	}
}
