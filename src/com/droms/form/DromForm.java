package com.droms.form;

import java.util.ArrayList;
import java.util.List;

import com.droms.action.BaseAction;
import com.droms.model.Drom;
import com.droms.service.DromService;
import com.droms.service.impl.DromServiceImpl;

public class DromForm extends BaseAction{

	private DromService service = new DromServiceImpl();
	
	private List<Drom> list = new ArrayList<Drom>();
	private Drom drom;
	
	
	/**
	 * 宿舍信息 页面
	 * @return
	 */
	public String listForm(){
		base();
		list = service.findAllDrom(power);
		return SUCCESS;
		
	}
	/**
	 * 添加宿舍 页面
	 * @return
	 */
	public String addForm(){
		base();
		return power == 0 ? SUCCESS : INPUT;
		
	}
	/**
	 * 修改宿舍 页面
	 * @return
	 */
	public String updateForm(){
		base();
		return power == 0 ? SUCCESS : INPUT;
		
	}
	
	public List<Drom> getList() {
		return list;
	}
	public void setList(List<Drom> list) {
		this.list = list;
	}
	public Drom getDrom() {
		return drom;
	}
	public void setDrom(Drom drom) {
		this.drom = drom;
	}
}
