package com.tamim.dao;

import java.util.List;

import com.tamim.entity.Patient;

public interface PatientDao {
	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);
}
