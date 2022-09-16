package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.UserInfoBean;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.mapper.KinMapper;

@Service
public class KinService {

	@Autowired
	KinMapper kinMapper;

	public void newUserS(UserInfoBean userInfoBean) {

		kinMapper.newUserInfo(userInfoBean);

		System.out.println("1231");

	}

	public List<UserInfoBean> getUserInfo() {

		return kinMapper.getUserInfo();

	}
	
	
	/**
     * ユーザー情報主キー検索
     * @return 検索結果
     */
    public UserInfoBean findById(String id) {
		return  kinMapper.findById(id);
    }
    
    /**
     * ユーザ情報更新
     * @param userEditRequest リクエストデータ
     */
    public void update(UserUpdateRequest userUpdateRequest) {
    	kinMapper.userUpdate(userUpdateRequest);
    }

}
