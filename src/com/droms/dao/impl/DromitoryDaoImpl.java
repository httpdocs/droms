package com.droms.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.droms.dao.BaseDao;
import com.droms.dao.DromitoryDao;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.util.HibernateSessionFactory;

public class DromitoryDaoImpl extends BaseDaoImpl implements DromitoryDao, BaseDao {

	public List<Dromitory> findDromitory(int power) {
		Session session = HibernateSessionFactory.getSession();
		if(power == 0){
			String hql ="from Dromitory";
			@SuppressWarnings("unchecked")
			List<Dromitory> list = session.createQuery(hql).list();
			list.remove(0);
			session.close();
			return list;
			
		}else{
			String hql ="from Dromitory d where d.id = :power ";
			@SuppressWarnings("unchecked")
			List<Dromitory> list = session.createQuery(hql)
					.setParameter("power", power)
					.list();
			session.close();
			return list;
		}
	}

	public boolean addDromitory(Dromitory dromitory) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(dromitory);
		session.getTransaction().commit();
		return true;
	}

	public boolean isDromitoryByid(int id) {
		Session session = HibernateSessionFactory.getSession();
		Dromitory d = (Dromitory) session.get(Dromitory.class, id);
		if(d ==null){
			return false;
		}
		return true;
	}

	/**
	 * 判断寝室楼里面有没有寝室
	 * @return
	 */
	public boolean isDromByDromitory(Dromitory dromitory) {
		Set<Drom> droms = dromitory.getDroms();
		System.out.println(droms);
		if(droms.size() > 0 ){
			return true;
		}
		return false;
	}

	/**
	 * 删除寝室
	 * @param dromitory
	 */
	public void deleteDromitory(Dromitory dromitory) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.delete(dromitory);
		session.getTransaction().commit();
		session.close();
	}

	public Dromitory findDromitoryById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Dromitory dromitory = (Dromitory)session.get(Dromitory.class, id);
		return dromitory;
	}

}
