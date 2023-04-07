package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/")
	public String home( Model model) {
		model.addAttribute("title", "Каталог");
		return "catalog-main";
	}
	@GetMapping("/shoppingCart")
	public String catalog( Model model) {
		model.addAttribute("title", "Корзина");
		return "shopping-cart";
	}
}

