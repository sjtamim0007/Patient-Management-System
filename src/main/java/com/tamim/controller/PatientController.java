package com.tamim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tamim.dao.PatientDao;
import com.tamim.entity.Patient;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientDao patientDao;
	
	@RequestMapping("/list")
	public String listPatient(Model theModel) {
		
		//get patient from dao
		List<Patient> thePatients = patientDao.getPatients();
		
		//add the patient to the model
		theModel.addAttribute("patients",thePatients);
		
		return "list-patient";
	}
}
