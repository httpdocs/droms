package com.droms.service;

import java.util.List;

import com.droms.model.Admin;

public interface AdminService {

	/**
	 * 登录
	 * @param admin
	 * @return
	 */
	public boolean login(Admin admin);
	
	/**
	 * 注册
	 * @param admin
	 * @return
	 */
	public boolean regist(Admin admin);

	/**
	 * 查找楼
	 * @return
	 */
	public List<Integer> findDromitory();
	
}
