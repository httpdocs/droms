package com.droms.action;

import java.util.List;

import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.service.DromService;
import com.droms.service.impl.DromServiceImpl;

public class DromAction extends BaseAction {

	private DromService service = new DromServiceImpl();
	
	private List<Drom>  dromList;
	
	private Drom drom;
	
	private Dromitory dromitory;
	
	private int id;
	
	
	
	/**
	 * 按寝室号查询
	 * @return
	 */
	public String findDrom(){
		dromList = service.findAllDrom(power);
		return SUCCESS;
		
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String addDrom(){
		base();
		return service.addDrom(drom, dromitory) ? SUCCESS : ERROR;
		
	}
	/**
	 * 修改
	 * @return
	 */
	public String updateDrom(){
		if(service.updateDrom(drom, power)){
			return SUCCESS;
		}
		return ERROR;	
	}
	/**
	 * 删除
	 * @return
	 */
	public String deleteDrom(){
		base();
		if(power == 0){
			service.deleteDrom(id);
		}
		return SUCCESS;
	}
	
	public List<Drom> getDromList() {
		return dromList;
	}
	public void setDromList(List<Drom> dromList) {
		this.dromList = dromList;
	}
	public Drom getDrom() {
		return drom;
	}
	public void setDrom(Drom drom) {
		this.drom = drom;
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
