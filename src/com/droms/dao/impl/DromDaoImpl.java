package com.droms.dao.impl;


import java.util.List;

import org.hibernate.Session;

import com.droms.dao.BaseDao;
import com.droms.dao.DromDao;
import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.model.Student;
import com.droms.util.HibernateSessionFactory;

public class DromDaoImpl extends BaseDaoImpl implements DromDao, BaseDao{

	public List<Drom> findDromsByPower(int power) {
		Session session = HibernateSessionFactory.getSession();
		if(power == 0 ){
			String hql = "from Drom";
			@SuppressWarnings("unchecked")
			List<Drom> list = session.createQuery(hql).list();
			System.out.println(list);
			return list;
		}else{
			String hql = "from Drom d where d.dromitory.id = :id";
			@SuppressWarnings("unchecked")
			List<Drom> list = session.createQuery(hql)
			.setParameter("id", power)
			.list();
			System.out.println(list);
			return list;
		}
	}

	public List<Drom> findByDromId(int id, int power) {
		Session session = HibernateSessionFactory.getSession();
		if(power == 0 ){
			String hql = "from Drom d where d.id = :id";
			@SuppressWarnings("unchecked")
			List<Drom> list = session.createQuery(hql)
			          .setParameter("id", id)
			          .list();
			System.out.println(list);
			return list;
		}else{
			String hql1 = "from Dromitory dt where dt.id = :id";
			Dromitory dormitory = (Dromitory)session.createQuery(hql1)
					.setParameter("id", power).uniqueResult();
			String hql = "from Drom d where d.dormitorys = :dormitorys and d.id = :id";
			@SuppressWarnings("unchecked")
			List<Drom> list = session.createQuery(hql)
					.setParameter("dormitorys", dormitory)
					.setParameter("id", id)
					.list();
			return list;
		}
	}

	public boolean deleteDromById(int id) {
		Drom drom = getDrom(id);
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		drom.setDromitory(null);
		session.delete(drom);
		session.getTransaction().commit();
		session.close();
		return true;
		
	}

	public boolean addDrom(Drom drom) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(drom);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean updateDrom(Drom drom, int power) {
		Session session = HibernateSessionFactory.getSession();
		if(power != 0){
			return false;
			
		}
		String hql1 = "from Dromitory dt where dt.id = :id";
		List<Dromitory> dromitorylist = session.createQuery(hql1)
				.setParameter("id", power).list();
		if(dromitorylist == null || dromitorylist.size() == 0){
			return false;
		}
		String hql = "from Drom d where d.dormitorys = :dormitorys and d.id = :id";
			@SuppressWarnings("unchecked")
			List<Drom> dromlist = (List<Drom>) session.createQuery(hql)
					.setParameter("dormitorys", dromitorylist.get(0))
					.setParameter("id", drom.getId())
					.list();
			if(dromlist != null && dromlist.size() != 0){
				return false;
			}
			System.out.println(drom);
			session.beginTransaction();
			session.update(drom);
			session.getTransaction().commit();
			return true;
	}

	public int getPowerByAdmin(Admin admin) {
		String hql = "from Dromitory d where d.admin = :admin";
		Session session = HibernateSessionFactory.getSession();
		Dromitory d = (Dromitory) session.createQuery(hql)
				.setParameter("admin", admin)
				.uniqueResult();
		return d.getId();
	}

	public Drom getDrom(int id) {
		Session session = HibernateSessionFactory.getSession();
		Drom drom = (Drom)session.get(Drom.class, id);
		return drom;
		
		
	}


}
