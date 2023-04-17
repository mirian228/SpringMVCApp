package com.proj.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proj.springweb.dao.PersonDAO;
import com.proj.springweb.models.Person;

@Controller
@RequestMapping("/admin")
public class AdminController {

	public final PersonDAO personDAO;

	@Autowired
	public AdminController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@GetMapping()
	public String adminPage(Model model, @ModelAttribute("person") Person person) {
		model.addAttribute("people", personDAO.getAllPeople());
		return "adminPage";
	}

	@PatchMapping("/add")
	public String makeAdmin(@ModelAttribute("person") Person person) {
		System.out.println(person.getId());
		return "redirect:/people";
	}

}
