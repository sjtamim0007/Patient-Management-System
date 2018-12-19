package com.tamim.dao;

import java.util.List;

import com.tamim.entity.Doctor;
import com.tamim.entity.Patient;


public interface DoctorDao {
	public List<Doctor> getDoctors();
	
	public void saveDoctor(Doctor theDoctor);
	
	public Doctor getDoctor(int theId);

	public void deleteDoctor(int theId);
	
	public List<Doctor> searchDoctor(String theSearchName);
}
