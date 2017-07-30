package com.droms.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;




import com.droms.model.Admin;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	protected Admin admin;
	
	protected int power;
	
	protected String username;
	
	private HttpSession session = ServletActionContext.getRequest().getSession();

	public void saveSession(String username, int power){
		
		session.setAttribute("username", username);
		session.setAttribute("power", power);
	}
	
	public void base(){
		username =  (String) getSession().getAttribute("username");
		power = (Integer) getSession().getAttribute("power");
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

}
