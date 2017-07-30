package com.droms.test;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Test;

import com.droms.dao.AdminDao;
import com.droms.dao.impl.AdminDaoImpl;
import com.droms.model.Admin;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.util.HibernateSessionFactory;

public class RegistTest {

	@Test
	public void test(){
		Dromitory d = new Dromitory();
		d.setId(0);
		
		Admin admin = new Admin();
		admin.setUsername("ryan");
		admin.setName("ss");
		admin.setPassword("123");
		
		
		System.out.println(admin);
		Session session = HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
	}
	@Test
	public void test1(){
		Dromitory d = new Dromitory();
		d.setId(0);
		
		Admin admin = new Admin();
		admin.setUsername("ryan");
		admin.setName("ss");
		admin.setPassword("123");
		
		
		AdminDao damindao = new AdminDaoImpl();
		
		
		System.out.println(damindao.isExistByUserName("ryan"));
		
	}
	@Test
	public void test3(){
		Drom d  = new Drom();
		d.setDromid(111);
		
		System.out.println(d);
	}
	
}
