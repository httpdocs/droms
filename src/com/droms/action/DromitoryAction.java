package com.droms.action;

import com.droms.model.Dromitory;
import com.droms.service.DromitoryService;
import com.droms.service.impl.DromitoryServiceImpl;

public class DromitoryAction extends BaseAction {
	
	private DromitoryService service = new DromitoryServiceImpl();

	private Dromitory dromitory;
	
	private int id;
	
	/**
	 * 添加宿舍楼 action
	 * @return
	 */
	public String add(){
		base();
		int typeNo = Integer.parseInt(dromitory.getType());
		if(typeNo == 0){
			dromitory.setType("男生宿舍楼");		
		}
		else{
			dromitory.setType("女生宿舍楼");	
		}
		service.addDromitory(dromitory);
		return SUCCESS;
	}
	/**
	 * 修改宿舍楼 action
	 * @return
	 */
	public String update(){
		service.deleteDromitory(dromitory.getId());
		service.addDromitory(dromitory);
		return SUCCESS;
	}
	
	/**
	 * 查询宿舍楼 action
	 * @return
	 */
	public String find(){
		return SUCCESS;
	}
	/**
	 * 删除宿舍楼 action
	 * @return
	 */
	public String delete(){
		base();
		if(power  == 0){
			service.deleteDromitory(id);
		}
		return SUCCESS;
	}
	public Dromitory getDromitory() {
		return dromitory;
	}
	public void setDromitory(Dromitory dromitory) {
		this.dromitory = dromitory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
