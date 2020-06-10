package com.dangphuongpham.myemployeesapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="employees")

public  class employees {

	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public int getPayperhour() {
		return payperhour;
	}
	public void setPayperhour(int payperhour) {
		this.payperhour = payperhour;
	}
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Id @Size(min=6, max=6) @Column(columnDefinition="TEXT",name="empid", nullable=false)
	private String id;
	@Size(min=2, max=35) @Column(columnDefinition="TEXT", name="name", length=35)
	private String name;
	@Size(min=2, max=15) @Column(columnDefinition="TEXT", name="jobtitle", length=15)
	private String jobtitle;
	@Min(1) @Column(name="payperhour")
	private int payperhour;	
	
	
}