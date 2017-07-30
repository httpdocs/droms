package com.droms.model;

import java.util.HashSet;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 宿舍
 *  id: 宿舍号
 *  size: 宿舍中的人数
 *  dormitory: 多队一关系，所在的楼
 *  students: 多对多关系，宿舍中的学生
 * 
 * @author Ryan
 * 
 */
@Entity
public class Drom {

	@Id
	@GeneratedValue
	private int id;
	
	private int dromid;
	
	@ManyToOne(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER)
	private Dromitory dromitory;

	
	@OneToMany(mappedBy = "drom",
				cascade = CascadeType.ALL
			)
	private Set<Student> students = new HashSet<Student>();

	
	
	@Override
	public String toString() {
		return dromid + " ";
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDromid() {
		return dromid;
	}



	public void setDromid(int dromid) {
		this.dromid = dromid;
	}



	public Dromitory getDromitory() {
		return dromitory;
	}



	public void setDromitory(Dromitory dromitory) {
		this.dromitory = dromitory;
	}



	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}






}
