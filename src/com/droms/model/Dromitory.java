package com.droms.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * 宿舍楼
 * id: 			楼号
 * type:		楼的类型
 * admin:		一对一关系，楼的管理员
 * dorms:		多对多关系，楼拥有的宿舍
 * @author Ryan
 *
 */
@Entity
public class Dromitory {

	@Id
	private int id;
	
	private String type;
	
	@OneToOne(
			mappedBy = "dromitory",
			fetch = FetchType.EAGER
			)
	private Admin admin;

	@OneToMany(
				mappedBy = "dromitory",
				fetch = FetchType.EAGER
			)
	private Set<Drom> droms = new HashSet<Drom>();
	
	
	@Override
	public String toString() {
		return "" + id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}


	public Set<Drom> getDroms() {
		return droms;
	}


	public void setDroms(Set<Drom> droms) {
		this.droms = droms;
	}
	
	
	
}
