package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.InfoBean;
import com.example.demo.mapper.KinMapper;

@Service
public class KinService {

	@Autowired
	KinMapper kinMapper;
	
	public void  newUserS(String id, String name ) {
		
		
		kinMapper.newUser(id, name);
		
		System.out.println("KinService");
		
	}
	
	public InfoBean sbi(String id) {
		
		
	return	kinMapper.selectById(id);
	}
	
}
