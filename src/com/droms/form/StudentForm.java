package com.droms.form;

import java.util.ArrayList;
import java.util.List;

import com.droms.action.BaseAction;
import com.droms.model.Admin;
import com.droms.model.Student;
import com.droms.service.StudentService;
import com.droms.service.impl.StudentServiceImpl;

public class StudentForm extends BaseAction {

	
	private StudentService service = new StudentServiceImpl();
	
	private List<Student> list = new ArrayList<Student>();
	
	private int id;
	
	private Student stu;
	
	
	/**
	 * 学生信息页面
	 * @return
	 */
	public String listForm(){
		base();
		list = service.findStudents(power);
		return SUCCESS;
	}
	
	/**
	 * 添加学生 页面
	 * @return
	 */
	public String addForm(){
		base();
		return power == 0 ? SUCCESS : INPUT;
		
	}
	/**
	 * 修改学生页面
	 * @return
	 */
	public String updateForm(){
		base();
		if(power > 0) return INPUT;
		setStu(service.findStudentById(id));
		return SUCCESS;
		
	}
	
	
	
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}
	
	
}
