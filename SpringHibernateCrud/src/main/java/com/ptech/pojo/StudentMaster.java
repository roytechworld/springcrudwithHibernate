package com.ptech.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Software : PR Stock software
 * Developer : Pradipto Roy (Java developer)
 */

@Entity
@Table(name="studentmaster",catalog="practicedatabase")
public class StudentMaster {
	
	private String stid;
	private String name;
	private String address;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="studentid",nullable=false,unique=true)
	public String getStid() {
		return stid;
	}
	public void setStid(String stid) {
		this.stid = stid;
	}
	@Column(name="studentname",length=45 )
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="address",length=100)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public StudentMaster(String stid, String name, String address) {
		super();
		this.stid = stid;
		this.name = name;
		this.address = address;
	}
	public StudentMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	

}
