package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.KinService;

@Controller

public class KinController {

	@Autowired
	KinService kinService;
	
	@RequestMapping(value = "kin")
	public String homePage(Model model,HttpServletRequest request) {

		return "kin";
	}
	

@GetMapping("/kinEdd")
public ModelAndView toEdd(@RequestParam String name,String id) {

	kinService.newUserS(id, name);
		
	ModelAndView mav = new ModelAndView("kin");
	
	return mav;
	
}

public ModelAndView CreatInfo(@RequestParam String name,String id) {
	kinService.sbi(id);
	
	ModelAndView kin = new ModelAndView("kin");
	
	System.out.println(123123);
	
	return kin;
	
	
	
}
	
}
