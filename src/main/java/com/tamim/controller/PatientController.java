package com.tamim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tamim.entity.Patient;
import com.tamim.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@GetMapping("/list")
	public String listPatient(Model theModel) {

		// get patient from service
		List<Patient> thePatients = patientService.getPatients();

		// add the patient to the model
		theModel.addAttribute("patients", thePatients);

		return "list-patient";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Patient thePatient = new Patient();
		theModel.addAttribute("patient", thePatient);

		return "patient-form";
	}

	@PostMapping("/savePatient")
	public String savePatient(@ModelAttribute("patient") Patient thePatient) {
		
		//Save the patient using service
		patientService.savePatient(thePatient);
		
		return "redirect:/patient/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId")int theId, Model theModel) {
		
		Patient thePatient = patientService.getPatient(theId);
		
		theModel.addAttribute("patient",thePatient);
		
		return "patient-form";
	}
	
	@GetMapping("/delete")
	public String deletePatient(@RequestParam("patientId")int theId) {
		
		patientService.deletePatient(theId);
		
		return "redirect:/patient/list";
	}
}
