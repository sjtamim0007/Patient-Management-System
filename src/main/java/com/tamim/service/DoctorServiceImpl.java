package com.tamim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tamim.dao.DoctorDao;
import com.tamim.entity.Doctor;


@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Override
	@Transactional
	public List<Doctor> getDoctors() {
		return doctorDao.getDoctors();
	}
	
	@Override
	@Transactional
	public void saveDoctor(Doctor theDoctor) {
		doctorDao.saveDoctor(theDoctor);
	}
	
	@Override
	@Transactional
	public List<Doctor> searchDoctor(String theSearchName) {
		return doctorDao.searchDoctor(theSearchName);
	}

	@Override
	@Transactional
	public Doctor getDoctors(int theId) {
		return doctorDao.getDoctor(theId);
	}

	@Override
	@Transactional
	public void deleteDoctor(int theId) {
		doctorDao.deleteDoctor(theId);
		
	}

}
