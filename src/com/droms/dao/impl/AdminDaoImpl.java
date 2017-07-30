package com.droms.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.droms.dao.AdminDao;
import com.droms.model.Admin;
import com.droms.model.Dromitory;
import com.droms.util.HibernateSessionFactory;

public class AdminDaoImpl implements AdminDao{
	

	public boolean isExistByUserName(String username) {
		Session session = HibernateSessionFactory.getSession();
		
		String hql = "from Admin admin where admin.username = :username";
		@SuppressWarnings("unchecked")
		List<Admin> list = session.createQuery(hql)
				.setString("username", username)
				.list();
		return (list == null || list.size() == 0) ? false : true;
	}

	public boolean isTrueBypassword(Admin admin) {
		String hql = "from Admin admin where admin.username = :username and admin.password = :password";
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Admin> list = session.createQuery(hql)
				.setString("username", admin.getUsername())
				.setString("password",admin.getPassword())
				.list();
		return (list == null || list.size() == 0) ? false : true;
	}


	public void login(Admin admin) {
		
	}

	public void regist(Admin admin) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Dromitory dromitory = (Dromitory) session.get(Dromitory.class, admin.getDromitory().getId());
		if(dromitory == null){
			dromitory = new Dromitory();
			dromitory.setId(0);
		}
		admin.setDromitory(dromitory);
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}

	/*
	 * 获取权限 
	 * (non-Javadoc)
	 * @see com.droms.dao.AdminDao#getDromitoryByAdmin(com.droms.model.Admin)
	 */
	public int getPowerByAdmin(Admin admin) {
		String sql = "select dromitory_id from admin where username = ?";
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Integer> list = session.createSQLQuery(sql)
				.setParameter(0, admin.getUsername())
				.list();
		session.close();
		return list.get(0);
		
	}

	public Admin getAdmin(String username) {
		String hql = "from Admin d where d.username = :username";
		Session session = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<Admin> list = session.createQuery(hql)
				.setParameter("username", username)
				.list();
		return list.get(0);
	}

	public List<Integer> findDromitory() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "select d.id from Dromitory d where d.id > 0";
		List<Integer> list = session.createQuery(hql).list();
		return list;
	}

	public boolean isExistByDromitory(int id) {
		if(id == 0){
			return false;
		}
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Admin a where a.dromitory.id = :id";
		Admin admin = (Admin) session.createQuery(hql)
				.setParameter("id", id)
				.uniqueResult();
		if(admin == null){
			return false;
		}
		return true;
	}

	public Admin findAdmin(String username) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Admin a where a.username = :username";
		Admin admin = (Admin) session.createQuery(hql).setParameter("username", username).uniqueResult();
		return admin;
	}

	public void updateAdmin(Admin newadmin) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.update(newadmin);
		session.getTransaction().commit();
		session.close();
		
		
	}

	public void deleteAdmin(Admin admin) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.delete(admin);
		session.getTransaction().commit();
		session.close();
	}

}
