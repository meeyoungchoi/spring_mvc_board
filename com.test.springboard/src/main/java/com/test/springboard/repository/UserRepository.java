package com.test.springboard.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.springboard.entity.UserEntity;

@Repository
public class UserRepository {
	
	@Autowired
	private IUserMapper userMapper;
	
	
	public void insert(UserEntity user) {
		userMapper.insert(user);		
	}
	
	public UserEntity detail(String userId) {
		return userMapper.detail(userId);
	}
	
	public List<UserEntity> getUserList() {
		return userMapper.getUserList();
	}
	
	
	public void update(UserEntity entity) {
		userMapper.update(entity);
	}
	
	public void delete(String userId) {
		userMapper.delete(userId);
	}
	
	
	
	
	
	

}
