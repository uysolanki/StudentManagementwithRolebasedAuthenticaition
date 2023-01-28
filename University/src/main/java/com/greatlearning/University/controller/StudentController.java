package com.greatlearning.University.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.University.entity.Student;
import com.greatlearning.University.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

		@Autowired
		StudentServiceImpl studserv;
		
	@RequestMapping("/list")	
	public String listStudents(Model model)
	{
		List<Student> mystudents=studserv.findAll();
		model.addAttribute("studentjsp",mystudents);
		return "list-Students";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, 
			Model model)
	{
		Student studentfromdb=studserv.findById(id);
		model.addAttribute("StudentUI",studentfromdb);
		return "Student-form";
	}
	
	
	@PostMapping("/save")
	public String saveStudent(
	@RequestParam("id") int id,
	@RequestParam("firstName") String firstName,
	@RequestParam("lastName") String lastName,
	@RequestParam("course") String course,
	@RequestParam("country") String country
	)
	{
		Student student=new Student();
		student.setId(id);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);
		
		studserv.save(student);
		return "redirect:/student/list";
	}
		
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model)
	{
		Student student=new Student();
		model.addAttribute("StudentUI",student);
		return "Student-form";
	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("studentId") int id)
	{
		studserv.deleteById(id);
		return "redirect:/student/list";
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
