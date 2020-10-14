package com.test.springboard.repository;



import java.util.List;

import com.test.springboard.entity.UserEntity;

public interface IUserMapper {
	void insert(UserEntity user);
	
	List<UserEntity> getUserList();
	
	UserEntity detail(String userId);
	
	void update(UserEntity entity);
	
	void delete(String userId);
	
}

