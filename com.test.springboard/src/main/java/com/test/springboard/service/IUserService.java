package com.test.springboard.service;



import com.test.springboard.entity.UserEntity;

public interface IUserService {
	
	void insert(UserEntity user);
	
	
	Iterable<UserEntity> getUserList();
	
	
	UserEntity detail(String userId);
	
	
	void update(UserEntity user, String userId);
	
	void delete(String userId);
	
}
