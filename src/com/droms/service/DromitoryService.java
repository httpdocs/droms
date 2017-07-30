package com.droms.service;

import java.util.List;

import com.droms.model.Dromitory;

public interface DromitoryService {

	/**
	 * 查询所有楼信息
	 * @return
	 */
	public List<Dromitory> findDromitoryByPower(int power);
	
	/**
	 * 添加宿舍楼
	 * @param dromitory
	 * @return
	 */
	public boolean addDromitory(Dromitory dromitory);
	
	/**
	 * 修改楼信息
	 * @param dromitory
	 * @return true 成功 false 失败
	 */
	public boolean updateDromitory(Dromitory dromitory);
	
	/**
	 * 删除楼
	 * @param id
	 * @return
	 */
	public boolean deleteDromitory(int id);

	/**
	 * 查找寝室
	 * @param id
	 * @return
	 */
	public Dromitory findDromitory(int id);
}
