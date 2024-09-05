package com.webProject.myapplication.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@RequestMapping("/")
	public String home() {
		return "This is from home home";
	}
	@RequestMapping("/about")
	public String abouts() {
		return "This is about section";
	}
}
