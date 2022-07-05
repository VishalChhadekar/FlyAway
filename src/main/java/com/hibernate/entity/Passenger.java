package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="PassengersDetails")
public class Passenger {
	@Id
	@GeneratedValue
	@Column(name="Pass_ID")
	private int pId;
	@Column(name="P_Name")
	private String pName;
	@Column(name="P_Age")
	private int pAge;
	@Column(name="P_Nationality")
	private String pNationality;
	
	
	/*
	 * @ManyToOne(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="cust_id") private Customer cusomer;
	 */
	
	//getter and setter
	
	
	
	public String getpName() {
		return pName;
	}

	/*
	 * public Customer getCusomer() { return cusomer; } public void
	 * setCusomer(Customer cusomer) { this.cusomer = cusomer; }
	 */
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpAge() {
		return pAge;
	}
	public void setpAge(int pAge) {
		this.pAge = pAge;
	}
	public String getpNationality() {
		return pNationality;
	}
	public void setpNationality(String pNationality) {
		this.pNationality = pNationality;
	}
	
	

}
