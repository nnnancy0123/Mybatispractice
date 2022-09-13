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
import com.example.demo.service.KinService;

@Controller
public class KinController {

	@Autowired
	KinService kinService;

	//	@RequestMapping(value = "kin")
	//	public String homePage(Model model, HttpServletRequest request) {
	//
	//		return "kin";
	//}

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

	@PostMapping("/kinProcess")
	public ModelAndView CreatInfo(@RequestParam String id, @RequestParam String name, @RequestParam String age,  Model model) {

		UserInfoBean userInfoBean = new UserInfoBean();
		userInfoBean.setId(id);
		userInfoBean.setName(name);
		userInfoBean.setAge(age);
		
		kinService.newUserS(userInfoBean);
		
		List<UserInfoBean> userInfo = kinService.getUserInfo() ;
		model.addAttribute("getinfo", userInfo);

		ModelAndView kin = new ModelAndView("kinInfo");
		
		System.out.println("144");
		return kin;
		
	}
	
	
    /**
     * ユーザー編集画面を表示
     * @param id ユーザーID
     * @param model Model
     * @return ユーザー編集画面
     */
    @GetMapping("/kinInfoProcess")
    public String displayEdit(@PathVariable String id, Model model) {
    	KinService kinService= new KinService();
    	UserInfoBean user= kinService.findById(id);
    	user.setId(user.getId());
    	user.setId(user.getName());
    	user.setId(user.getAge());
    	
    	model.addAttribute("user", user);
    	
    	ModelAndView kinInfo = new ModelAndView("idInfo");
    	System.out.println("5566");
		
        return "kinInfo";
    }
	

}
