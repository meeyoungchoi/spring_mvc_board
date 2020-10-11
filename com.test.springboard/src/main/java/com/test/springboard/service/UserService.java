package com.test.springboard.service;

import java.util.List;

import javax.servlet.http.HttpSession;

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

	public UserEntity loginCheck(UserEntity loginUser) {
		System.out.println("service");
		System.out.println("로그인한 정보: " + loginUser.toString());
		UserEntity registeredUser = detail(loginUser.getUserId());
		
		//회원탈퇴된 정보로 로그인 하는 경우
		if (registeredUser == null) {
			System.out.println("존재하지 않는 회원입니다.");
			return registeredUser;
		} 

			
		System.out.println("회원가입된 정보: " + registeredUser.toString());
			
		
		
		
		//질문
		//로그인 성공한 경우 로그인 정보를 세션에 저장하기위해 status값을 컨트롤러로 전달
		//한후 컨트롤러에서 로그인 성공한 객체 정보를 세션에 저장해도 되는가? 
		boolean status = loginUser.checkIdPw(registeredUser);
		if (status == true) {
			System.out.println("service logincheck() status: " + status );
			
		} else {
			System.out.println("service logincheck() status false: " + status );
			registeredUser = null;
			
		}
		
			return registeredUser;		
	}

}
