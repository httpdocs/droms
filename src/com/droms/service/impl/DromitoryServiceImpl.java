package com.droms.service.impl;

import java.util.List;

import com.droms.dao.DromitoryDao;
import com.droms.dao.impl.DromitoryDaoImpl;
import com.droms.model.Dromitory;
import com.droms.service.DromitoryService;

public class DromitoryServiceImpl implements DromitoryService {

	private DromitoryDaoImpl dao = new DromitoryDaoImpl();

	public boolean addDromitory(Dromitory dromitory) {
		if(dao.isDromitoryByid(dromitory.getId())){
			System.out.println("==================宿舍楼已存在==============");
			return false;
		}
		dao.addDromitory(dromitory);
		System.out.println("==============宿舍楼添加成功=============");
		return true;
	}

	public boolean updateDromitory(Dromitory dromitory) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteDromitory(int id) {
		Dromitory dromitory = new Dromitory();
		dromitory.setId(id);
		dromitory = dao.getDromitory(dromitory);
		//判断寝室楼是否有寝室
		if(dao.isDromByDromitory(dromitory)){
			System.out.println("=========该楼还有寝室，不能删除=========");
			return false;
		}
		dao.deleteDromitory(dromitory);
		System.out.println("============删除成功===============");
		return true;
	}

	public List<Dromitory> findDromitoryByPower(int power) {
		// TODO Auto-generated method stub
		return dao.findDromitory(power);
	}

	public Dromitory findDromitory(int id) {
		return dao.findDromitoryById(id);
	}

}
