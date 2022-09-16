package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.bean.UserInfoBean;
import com.example.demo.dto.UserUpdateRequest;


@Mapper
public interface KinMapper {

	public void newUserInfo(UserInfoBean userInfoBean);

	public List<UserInfoBean> getUserInfo();

	/**
	 * ユーザー情報主キー検索
	 * @param id 主キー
	 * @return 検索結果
	 */
	public UserInfoBean findById(String id);

    
    /**
     * ユーザー情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    void userUpdate(UserUpdateRequest userUpdateRequest);

}
