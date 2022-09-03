package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.InfoBean;

@Mapper
public interface KinMapper {

	
	void newUser(String id,String name); 
	
	InfoBean selectById(String id);
}