package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.UserInfoBean;
import com.example.demo.mapper.KinMapper;

@Service
public class KinService {

	@Autowired
	KinMapper kinMapper;
	
	public void  newUserS(UserInfoBean userInfoBean ) {
		
		kinMapper.newUserInfo(userInfoBean);
		
		System.out.println("1231");
		
	}
	
	public List<UserInfoBean> getUserInfo(){
		
		return kinMapper.getUserInfo();
	
		
	}
	
	
}
