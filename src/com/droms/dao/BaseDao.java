package com.droms.dao;

import com.droms.model.Drom;
import com.droms.model.Dromitory;

public interface BaseDao {

	/**
	 * 判断宿舍楼是否存在
	 * @param dromitory
	 * @return
	 */
	public boolean isDromitory(int id);
	
	/**
	 * 判断宿舍是否存在
	 * @param dromitory
	 * @return
	 */
	public boolean isDrom(int id, Drom drom);
	
	/**
	 * 获取Dromitor
	 * @param dromitory
	 * @return
	 */
	public Dromitory getDromitory(Dromitory dromitory);
	
	/**
	 * 获取Drom
	 * @param drom
	 * @return
	 */
	public Drom getDrom(Drom drom ,int id);
}
