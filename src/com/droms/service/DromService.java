package com.droms.service;

import java.util.List;

import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;

public interface DromService {
	/**
	 * 查询所有宿舍信息
	 * @return
	 */
	public List<Drom> findAllDrom(int power);
	
	/**
	 * 根据宿舍号查询宿舍信息
	 * @return
	 */
	public List<Drom> findDromByDromId(int id ,int power);
	
	
	/**
	 * 根据宿舍查询学生信息
	 * @return
	 *//*
	public List<Student> findStudentByDrom(Drom drom);*/
	/**
	 * 添加宿舍
	 * @param dromitory
	 * @return
	 */
	public boolean addDrom(Drom drom ,  Dromitory dromitory);
	
	/**
	 * 修改宿舍信息
	 * @param dromitory
	 * @return true 成功 false 失败
	 */
	public boolean updateDrom(Drom drom, int power);
	
	/**
	 * 删除宿舍
	 * @param id
	 * @return
	 */
	public boolean deleteDrom(int id);

}
