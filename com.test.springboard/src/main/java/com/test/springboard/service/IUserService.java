package com.test.springboard.service;

import java.util.List;

import com.test.springboard.entity.UserEntity;

public interface IUserService {
	
	void insert(UserEntity user);
	
	
	List<UserEntity> getUserList();
	
	
	UserEntity detail(String userId);
	
	
	void update(UserEntity user, String userId);
	
	void delete(String userId);
	
}
