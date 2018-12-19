package com.tamim.service;

import java.util.List;

import com.tamim.entity.Doctor;



public interface DoctorService {
	public List<Doctor> getDoctors();
	
	public void saveDoctor(Doctor theDoctor);
	
	public Doctor getDoctors(int theId);

	public void deleteDoctor(int theId);
	
	public List<Doctor> searchDoctor(String theSearchName);
}
