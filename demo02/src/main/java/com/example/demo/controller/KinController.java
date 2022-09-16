package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.UserInfoBean;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.service.KinService;

@Controller
public class KinController {

	@Autowired
	KinService kinService;

	/*
	 * 
	 * @return
	 * 
	 */
	@GetMapping("/kin")
	public ModelAndView register() {

		ModelAndView mav = new ModelAndView("kin");

		return mav;
	}

	/**
	 * ユーザー新規登録画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@PostMapping("/userProcess")
	public ModelAndView CreatInfo(@RequestParam String id, @RequestParam String name, @RequestParam String age,
			Model model) {

		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setId(id);
		userInfoBean.setName(name);
		userInfoBean.setAge(age);

		kinService.newUserS(userInfoBean);

		List<UserInfoBean> userInfo = kinService.getUserInfo();
		model.addAttribute("getinfo", userInfo);

		ModelAndView kin = new ModelAndView("userInfo");

		System.out.println("144");
		return kin;
	}

	/**
	 * ユーザー詳細画面を表示
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/userInfo/{id}")
	public String displayEdit(@PathVariable String id, Model model) {

		UserInfoBean user = kinService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(user.getId());
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setAge(user.getAge());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		//ModelAndView kinInfo = new ModelAndView("idInfo");
		System.out.println("5566");
		return "/userInfoEdit";

	}

}
