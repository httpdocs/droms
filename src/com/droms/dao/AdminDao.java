package com.droms.dao;

import java.util.List;

import com.droms.model.Admin;

public interface AdminDao {

	/**
	 * 根据用户名判断用户是否存在
	 * @param username 
	 * @return
	 */
	public boolean isExistByUserName(String  username);
	
	/**
	 * 判断密码是否正确
	 * @param admin
	 * @return
	 */
	public boolean isTrueBypassword(Admin admin);
	
	/**
	 * 通过管理员获得其权限
	 * @param admin
	 * @return
	 * 	返回 0  ： 超级管理员
	 *  
	 */
	public int getPowerByAdmin(Admin admin);
	
	/**
	 * 登录
	 * @param admin
	 */
	public void login(Admin admin);
	
	/**
	 * 注册
	 * @param admin
	 */
	public void regist(Admin admin);
	
	/**
	 * 获取数据库中的Admin
	 * @param username
	 * @return
	 */
	public Admin getAdmin(String username);

	/**
	 * 
	 * @return
	 */
	public List<Integer> findDromitory();

	/**
	 * 通过楼判断管理员是否注册
	 * @param id
	 * @return
	 */
	public boolean isExistByDromitory(int id);
	
}
