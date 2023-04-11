package com.proj.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	
	//@RequestParam() annotation is better approach than creating HttpServletRequest object --> 
	// --> To get Request Body from get Method
	// Now the url will be /first/hello?name
	@GetMapping("/hello")
	public String helloPage(@RequestParam("name") String name, @RequestParam("surname") String surname) {
		
		System.out.println("Hello, " + name + " " + surname );
		
		return "first/hello";
	}
	
	/*// This approach requires more core and we create object which stores all information which we may not need
	 * @GetMapping("/hello") public String helloPage(HttpServletRequest request) {
	 * String name = request.getParameter("name"); return "first/hello"; }
	 */

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}

}
