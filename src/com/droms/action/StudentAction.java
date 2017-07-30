package com.droms.action;

import java.util.ArrayList;
import java.util.List;

import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;
import com.droms.service.StudentService;
import com.droms.service.impl.StudentServiceImpl;

public class StudentAction extends BaseAction {
	
	private StudentService service = new StudentServiceImpl();
	
	private List<Student> list = new ArrayList<Student>();
	
	private Student stu;
	
	
	private Drom drom;
	
	private String studentid;
	
	private int id;
	
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		base();
		return service.addStudent(stu, drom ) ? SUCCESS : ERROR ;
		
	}
	/**
	 * 查询
	 * @return
	 */
	public String find(){
		base();
		list = service.findStudentById(studentid, power);
		return "find";
		
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		return service.deleteStudentById(id) ? SUCCESS : ERROR;
		
	}
	/**
	 * 修改
	 * @return
	 */
	public String update(){
		service.deleteStudentById(id);
		return service.addStudent(stu, drom) ? SUCCESS : ERROR ;
		
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Drom getDrom() {
		return drom;
	}
	public void setDrom(Drom drom) {
		this.drom = drom;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
