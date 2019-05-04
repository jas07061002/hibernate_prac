package com.learnspring.springdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String,String> countryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		// create a student object
		Student theStudent = new Student();
		
		// add the student object as a model attribute
		theModel.addAttribute("student",theStudent);
		
		theModel.addAttribute("theCountryOptions",countryOptions);

		return "student-form";
		
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("theStudent:" + theStudent.getFirstName()
		+ " " + theStudent.getLastName());
		
//		System.out.println("theStudent Country:" + theStudent.getCountry());
		
		
		return "student-confirmation";
		
	}

}
