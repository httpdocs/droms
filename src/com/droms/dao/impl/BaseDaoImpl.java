package com.droms.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.droms.dao.BaseDao;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.util.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao{

	public boolean isDromitory(int id) {
		Session session = HibernateSessionFactory.getSession();
		Dromitory d = (Dromitory) session.get(Dromitory.class, id);
		if(d == null){
			return false;
		}
		return true;
	}


	public boolean isDrom(int id, Drom drom) {
		System.out.println("=======添加的楼号" + id+"========");
		System.out.println("=======添加的寝室号" + drom.getDromid()+"========");
		
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Drom d where d.dromid = :dromid and d.dromitory.id = :id";
		@SuppressWarnings("unchecked")
		List<Drom> d = session.createQuery(hql)
				.setParameter("dromid", drom.getDromid())
				.setParameter("id", id)
				.list(); 
		if(d == null || d.size() ==0){
			return false;
		}
		return true;
	}


	public Dromitory getDromitory(Dromitory dromitory) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		dromitory = (Dromitory) session.get(Dromitory.class, dromitory.getId());
		return dromitory;
	}


	public Drom getDrom(Drom drom, int id) {
		System.out.println("=======获取的楼号" + id+"========");
		System.out.println("=======获取的寝室号" + drom.getDromid()+"========");
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Drom d where d.dromid = :dromid and d.dromitory.id = :id";
		@SuppressWarnings("unchecked")
		List<Drom> d = session.createQuery(hql)
				.setParameter("dromid", drom.getDromid())
				.setParameter("id", id)
				.list(); 
		return d.get(0);
	}

}
