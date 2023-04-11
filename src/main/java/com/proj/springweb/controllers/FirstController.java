package com.proj.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

	// @RequestParam() annotation is better approach than creating
	// HttpServletRequest object -->
	// --> To get Request Body from get Method
	// Now the url will be /first/hello?name
	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname, Model model) {
		model.addAttribute("message", "Hello, " + name + " " + surname);
		return "first/hello";
	}

	/*
	 * // This approach requires more core and we create object which stores all
	 * information which we may not need
	 * 
	 * @GetMapping("/hello") public String helloPage(HttpServletRequest request) {
	 * String name = request.getParameter("name"); return "first/hello"; }
	 */

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}

	@GetMapping("/calculator")
	public String calculatorPage(@RequestParam(value = "a", required = false) Integer a,
			@RequestParam(value = "b", required = false) Integer b,
			@RequestParam(value = "action", required = false) String action, Model model) {

		if ((action == null) == false) {

			if (action.equalsIgnoreCase("multiplication")) {
				model.addAttribute("message", "Result of multiplication = " + (a * b));
			}
			if (action.equalsIgnoreCase("addition")) {
				model.addAttribute("message", "Result of addition = " + (a + b));
			}
			if (action.equalsIgnoreCase("substraction")) {
				model.addAttribute("message", "Result of substraction = " + (a - b));
			}
			if (action.equalsIgnoreCase("division")) {
				model.addAttribute("message", "Result of division = " + (a / b));
			} else {
				model.addAttribute("message", "No query parameters have been used");
			}
		}

		return "first/calculator";
	}

}
