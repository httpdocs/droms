package com.droms.service.impl;

import java.util.List;
import com.droms.dao.impl.DromDaoImpl;
import com.droms.model.Drom;
import com.droms.model.Dromitory;
import com.droms.service.DromService;

public class DromServiceImpl implements DromService{

	private DromDaoImpl dao = new DromDaoImpl();
	
	
	public List<Drom> findAllDrom(int power) {
		return dao.findDromsByPower(power);
	}

	public List<Drom> findDromByDromId(int id, int power) {
		return dao.findByDromId(id, power);
	}

	/* 
	 * 添加寝室
	 */
	public boolean addDrom(Drom drom, Dromitory dromitory) {
		//判断寝室楼是否存在
		if(dao.isDromitory(dromitory.getId())){
			dromitory = dao.getDromitory(dromitory);
			if(!dao.isDrom(dromitory.getId(), drom)){
				drom.setDromitory(dromitory);
				return dao.addDrom(drom);
			}else{
				System.out.println("=========该楼中已存在该宿舍==========");
				return false;
			}
		}else{	
			System.out.println("===========楼号不存在==============");
			return false;
		}
		
	}

	public boolean updateDrom(Drom drom, int power) {
		// TODO Auto-generated method stub
		return dao.updateDrom(drom, power);
	}

	public boolean deleteDrom(int id) {
		Drom drom = dao.getDrom(id);
		//判断寝室里面是否有学生
		if(drom.getStudents().size() > 0){
			System.out.println("==========寝室中还有学生，不能删除===============");
			return false;
		}
		return dao.deleteDromById(id);
	}


}
