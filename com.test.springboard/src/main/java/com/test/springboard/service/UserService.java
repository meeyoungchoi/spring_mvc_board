package com.test.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboard.entity.UserEntity;
import com.test.springboard.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository repository;

	@Override
	public void insert(UserEntity user) {
		repository.insert(user);		
	}

	@Override
	public List<UserEntity> getUserList() {
		return repository.getUserList();
	}

	@Override
	public UserEntity detail(String userId) {
		return repository.detail(userId);
	}

	@Override
	public void update(UserEntity user, String userId) {
		System.out.println("user:" + user.toString());
		repository.update(user);
			
	}

	@Override
	public void delete(String userId) {
		System.out.println("userId: " + userId);
		repository.delete(userId);		
	}

}
