package com.droms.dao;

import java.util.List;

import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;

public interface StudentDao {
	
	
	/**
	 * 根据权限查询所有学生
	 * @return
	 */
	public List<Student> findStudentsByPower(int power);
	
	
	/**
	 * 根据学号查询学生
	 */
	public List<Student> findStudentById(String id ,int power);
	
	
	/**
	 * 根据学号删除学生
	 * @return
	 */
	public boolean deleteStudentById(int id);
	
	/**
	 * 添加学生
	 * @return
	 */
	public boolean addStudent(Student stu );
	
	
	
	/**
	 * 修改学生信息
	 * @param stu
	 * @return
	 */
	public boolean updateStudent(Student stu);	

	/**
	 * 通过管理员获得其权限
	 * @param admin
	 * @return
	 * 	返回 0  ： 超级管理员
	 *  
	 */
	public int getPowerByAdmin(Admin admin);


	

}
