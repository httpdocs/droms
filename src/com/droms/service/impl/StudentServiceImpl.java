package com.droms.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.droms.dao.BaseDao;
import com.droms.dao.StudentDao;
import com.droms.dao.impl.BaseDaoImpl;
import com.droms.dao.impl.StudentDaoImpl;
import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;
import com.droms.service.StudentService;

public class StudentServiceImpl  implements StudentService{

	private StudentDaoImpl dao = new StudentDaoImpl();

	public List<Student> findStudentById(String id, int power) {
		return dao.findStudentById(id, power);
	}

	public boolean deleteStudentById(int id) {
		return dao.deleteStudentById(id);
	}

	public boolean addStudent(Student stu, Drom drom) {
		if(dao.isStudentByid(stu)){
			return false;
		}
		int id = drom.getDromitory().getId();
		//判断寝室楼在不在
		if(dao.isDromitory(id)){
			//判断寝室在不在
			if(dao.isDrom(id, drom)){
				//获取寝室
				drom = dao.getDrom(drom, id);
				dao.addStudent(stu, drom);
				System.out.println("添加成功");
				return true;
			}else{
				System.out.println("寝室不存在");
				return false;
			}
		}else{
			System.out.println("寝室楼不存在");
			return false;
		}
	}

	public boolean updateStudent(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Student> findStudents(int power) {
		return dao.findStudentsByPower(power);
	}

	public Student findStudentById(int id) {
		// TODO Auto-generated method stub
		return dao.findStudentById(id);
	}
	

	
}
