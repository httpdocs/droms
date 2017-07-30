package com.droms.service;

import java.util.List;

import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;

public interface StudentService {
	
	
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
	public boolean addStudent(Student stu, Drom drom);
	
	
	
	/**
	 * 修改学生信息
	 * @param stu
	 * @return
	 */
	public boolean updateStudent(Student stu);
	
	
	
	/**
	 * 根据权限查找所有学生
	 * @return
	 */
	public List<Student> findStudents(int power);


	/**
	 * 通过id查找学生
	 * @param id
	 * @return
	 */
	public Student findStudentById(int id);
	

}
