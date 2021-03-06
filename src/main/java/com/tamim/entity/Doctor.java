package com.tamim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	@Column(name = "name")
	private String name;

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	@Column(name = "dept")
	private String dept;

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	@Column(name = "joining_date")
	private String joiningDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", dept=" + dept + ", joiningDate=" + joiningDate + "]";
	}

}
