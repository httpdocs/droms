package com.droms.dao.impl;



import java.util.List;


import org.hibernate.Session;

import com.droms.dao.BaseDao;
import com.droms.dao.StudentDao;
import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;
import com.droms.util.HibernateSessionFactory;

public class StudentDaoImpl extends BaseDaoImpl implements StudentDao, BaseDao{

	public List<Student> findStudentsByPower(int power) {
		Session session = HibernateSessionFactory.getSession();
		if(power == 0 ){
			String hql = "from Student";
			@SuppressWarnings("unchecked")
			List<Student> list = session.createQuery(hql).list();
			System.out.println(list.size());
			return list;
		}else{
			String hql = "from Student s where s.drom.dromitory.id = :id";
			@SuppressWarnings("unchecked")
			List<Student> list = session.createQuery(hql)
					.setParameter("id", power)
					.list();
			return list;
		}
	}


	public boolean deleteStudentById(int id) {
		Session session  = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Student stu  = (Student) session.get(Student.class, id);
		stu.setDrom(null);
		session.delete(stu);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	/**
	 * 
	 * 添加学生
	 * @param stu
	 * @param drom
	 * @return
	 */
	public boolean addStudent(Student stu ,Drom drom) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		stu.setDrom(drom);
		session.save(stu);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean updateStudent(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * 获取权限 
	 * (non-Javadoc)
	 * @see com.droms.dao.AdminDao#getDromitoryByAdmin(com.droms.model.Admin)
	 */
	public int getPowerByAdmin(Admin admin) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Dromitory d where d.admin = :admin";
		Dromitory d = (Dromitory) session.createQuery(hql)
				.setParameter("admin", admin)
				.uniqueResult();
		session.close();
		return d.getId();
	}


	public List<Student> findStudentById(String id, int power) {
		Session session = HibernateSessionFactory.getSession();
		if(power == 0 ){
			String hql = "from Student s where s.studentID = :id";
			@SuppressWarnings("unchecked")
			List<Student> list = session.createQuery(hql)
			.setParameter("id", id)
			.list();
			return list;
		}else{
			String hql = "from Student s where s.dromitory.id = :power and s.studentID = :id";
			@SuppressWarnings("unchecked")
			List<Student> list = session.createQuery(hql)
			.setParameter("power", power)
			.setParameter("id", id)
			.list();
			return list;
		}
	}


	public Student findStudentById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Student stu = (Student)session.get(Student.class, id);
		return stu;
	}


	public boolean addStudent(Student stu) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isStudentByid(Student stu) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Student s where s.studentID = :id";
		stu = (Student) session.createQuery(hql)
				.setParameter("id", stu.getStudentID())
				.uniqueResult();
		if(stu == null ){
			return false;
		}
		return true;
	}



	
}
