package com.tamim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tamim.dao.PatientDao;
import com.tamim.entity.Patient;
import com.tamim.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/list")
	public String listPatient(Model theModel) {
		
		//get patient from service
		List<Patient> thePatients = patientService.getPatients();
		
		//add the patient to the model
		theModel.addAttribute("patients",thePatients);
		
		return "list-patient";
	}
}
