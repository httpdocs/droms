package com.droms.test;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.droms.model.Admin;
import com.droms.service.AdminService;
import com.droms.service.impl.AdminServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class LoginTest {

	@Test
	public void test1(){
		AdminService a = new AdminServiceImpl();
		Admin ad = new Admin();
		ad.setUsername("ryan");
		ad.setPassword("123");
		a.login(ad);
		
	}
	
	@Test
	public void test2(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("11", "222");
		System.out.println(session);
	}
}
