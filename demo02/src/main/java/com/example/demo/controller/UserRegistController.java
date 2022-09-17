package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.UserInfoBean;
import com.example.demo.service.KinService;

@Controller
public class UserRegistController{

	@Autowired
	KinService kinService;

	/*
	 * 
	 * @return
	 * 
	 */
	@GetMapping("/regist")
	public ModelAndView register() {

		ModelAndView mav = new ModelAndView("regist");

		return mav;
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@PostMapping("/userInfoList")
	public ModelAndView CreatInfo(@RequestParam String id, @RequestParam String name, @RequestParam String age,
			Model model) {

		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setId(id);
		userInfoBean.setName(name);
		userInfoBean.setAge(age);
		kinService.createUser(userInfoBean);

		List<UserInfoBean> userInfo = kinService.getUserInfo();
		model.addAttribute("getinfo", userInfo);

		ModelAndView userInfoList = new ModelAndView("userInfoList");

		System.out.println("144");
		return userInfoList;
	}

}