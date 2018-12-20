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
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String name;
	
	@Column(name = "mobile")
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String mobileNumber;
	
	@Column(name = "age")
	@NotNull(message="is required")	
	private Integer age;
	
	@Column(name = "gender")
	@Size(min=1, message="is required")	
	private String gender;
	
	@Column(name = "occupation")
	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String occupation;

	public Patient() {

	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", age=" + age + ", gender="
				+ gender + ", occupation=" + occupation + "]";
	}
	
	

}
