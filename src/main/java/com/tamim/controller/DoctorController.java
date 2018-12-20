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

import com.tamim.entity.Doctor;
import com.tamim.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/list")
	public String listDoctors(Model theModel) {

		// get patient from service
		List<Doctor> theDoctors = doctorService.getDoctors();

		// add the patient to the model
		theModel.addAttribute("doctors", theDoctors);

		return "list-doctor";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Doctor theDoctor = new Doctor();
		theModel.addAttribute("doctor", theDoctor);

		return "doctor-form";
	}
	
	@PostMapping("/saveDoctor")
	public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor) {
		doctorService.saveDoctor(theDoctor);
		
		return "redirect:/doctor/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("doctorId") int theId, Model theModel) {

		Doctor theDoctor = doctorService.getDoctors(theId);

		theModel.addAttribute("doctor", theDoctor);

		return "doctor-form";
	}

	@GetMapping("/delete")
	public String deleteDoctor(@RequestParam("doctorId") int theId) {

		doctorService.deleteDoctor(theId);

		return "redirect:/doctor/list";
	}
	
	@PostMapping("/search")
	public String searchDoctor(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// get patient from service
		List<Doctor> theDoctors = doctorService.searchDoctor(theSearchName);

		// add the patient to the model
		theModel.addAttribute("doctors", theDoctors);

		return "list-doctor";
	}
}
