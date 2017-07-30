package com.droms.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 楼管理员
 * username:		登录用户
 * password:		登录密码
 * name:			管理员姓名
 * dormitory：		一对一关系，管理的楼
 * 
 * @author Ryan
 *
 */
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String password;
	
	private String name;

	@OneToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER
			)
	private Dromitory dromitory;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Dromitory getDromitory() {
		return dromitory;
	}

	public void setDromitory(Dromitory dromitory) {
		this.dromitory = dromitory;
	}
	
	
	
}
