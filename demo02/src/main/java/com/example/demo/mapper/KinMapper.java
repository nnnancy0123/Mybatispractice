package com.example.demo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.UserInfoBean;

@Mapper
public interface KinMapper {

	public void newUserInfo(UserInfoBean userInfoBean); 
	
	public List<UserInfoBean> getUserInfo();
	
}
