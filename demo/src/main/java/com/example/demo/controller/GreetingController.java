package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {

    @GetMapping("/")
	public String home( Model model) {
		model.addAttribute("title", "Гланая страница");
		return "catalog-main";
	}
}
