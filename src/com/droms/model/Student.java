package com.droms.model;

import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 	学生 实体类
 * 
 * id:			id
 * studentID    学号
 * name：		姓名
 * classroom	班级
 * phone		手机号
 * counselor	辅导员
 * start_time	入住时间
 * dromitory    多对一关系，所在宿舍楼
 * drom			多对一关系，所在宿舍
 * 
 * @author Ryan
 *
 */
@Entity
public class Student {

	
	@Id
	@GeneratedValue
	private int id;
	
	private String studentID;
	
	private String name;
	
	private String classroom;
	
	private String phone;
	
	private String counselor;
	
	@Temporal(TemporalType.DATE)
	private Date start_time;
	
	
	@ManyToOne(
				cascade = CascadeType.ALL,
				fetch = FetchType.EAGER
			)
	private Drom drom;

	@Override
	public String toString() {
		return name + " ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Drom getDrom() {
		return drom;
	}

	public void setDrom(Drom drom) {
		this.drom = drom;
	}

}
