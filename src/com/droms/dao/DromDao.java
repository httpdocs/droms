package com.droms.dao;

import java.util.List;

import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;

public interface DromDao {
	/**
	 * 根据权限查询所有宿舍
	 * @return
	 */
	public List<Drom> findDromsByPower(int power);
	
	
	/**
	 * 根据宿舍楼号查询宿舍
	 */
	public List<Drom> findByDromId(int id, int power);
	
	
	
	
	/**
	 * 根据宿舍号删除宿舍
	 * @return
	 */
	public boolean deleteDromById(int id);
	
	/**
	 * 添加宿舍
	 * @return
	 */
	public boolean addDrom(Drom drom);
	
	
	
	/**
	 * 修改宿舍信息
	 * @param stu
	 * @return
	 */
	public boolean updateDrom(Drom drom, int power);	

	/**
	 * 通过管理员获得其权限
	 * @param admin
	 * @return
	 * 	返回 0  ： 超级管理员
	 *  
	 */
	public int getPowerByAdmin(Admin admin);
	

}
