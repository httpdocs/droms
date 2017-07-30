package com.droms.dao;

import java.util.List;

import com.droms.model.Dromitory;

public interface DromitoryDao {

	/**
	 * 获取宿舍楼信息
	 * @param power
	 * @return
	 */
	public List<Dromitory> findDromitory(int power);
	
	/**
	 * 添加宿舍楼
	 * @param dromitory
	 * @return
	 */
	public boolean addDromitory(Dromitory dromitory);
	
	/**
	 * 判断寝室楼是否存在
	 * @param dromitory
	 * @return
	 */
	public boolean isDromitoryByid(int id);
	
	
}
