package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.bean.UserInfoBean;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.service.KinService;

@Controller
public class UserInfoController {
	
	@Autowired
	KinService kinService;
	
	
	/**
	 * ユーザー詳細画面を表示
	 * @param id ユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/userInfoDetail/{id}")
	public String displayEdit(@PathVariable String id, Model model) {

		UserInfoBean user = kinService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(user.getId());
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setAge(user.getAge());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		//ModelAndView kinInfo = new ModelAndView("idInfo");

		return "/userInfoEdit";

	}

	/**
	 * ユーザー更新
	 * @param userRequest リクエストデータ
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@PutMapping(value = "/userInfoEdit/{id}")
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "/userInfoEdit";
		}
		// ユーザー情報の更新
		kinService.update(userUpdateRequest);
		return "redirect:/userInfoList";
	}
}
