package com.tamim.service;

import java.util.List;

import com.tamim.entity.Patient;

public interface PatientService {
	public List<Patient> getPatients();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);
}
