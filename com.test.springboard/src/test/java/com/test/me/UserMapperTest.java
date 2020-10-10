package com.test.me;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.springboard.entity.UserEntity;
import com.test.springboard.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserMapperTest {
	
	
	@Autowired
	private IUserMapper mapper;
	
	@Test
	public void insertTest() {
		for (int i = 1; i < 6; i++) {
			UserEntity user = new UserEntity();
			user.setUserName("kim" + i);
			user.setUserId("user" + i);
			user.setUserPw("userpw" + i);
			mapper.insert(user);
		}
		System.out.println("insert 완료");
	}
	
	
	@Test
	public void getUserListTest() {
		List<UserEntity> list = mapper.getUserList();
		
		for (UserEntity user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void updateTest() {
		UserEntity user = new UserEntity();
		user.setUserName("kim2");
		user.setUserPw("kim2pw2");
		user.setUserId("user2");
		
		mapper.update(user);
		System.out.println("update: " + mapper.detail(user.getUserId()));
		
	}
	
	
	@Test
	public void detailTest() {
		UserEntity entity = mapper.detail("user2");
		if (entity == null) {
			System.out.println("없는 사용자 입니다.");
		} else {
			System.out.println("사용자: " + entity);
		}
		
	}
	
	
	@Test
	public void deleteTest() {
		mapper.delete("user3");
		UserEntity entity = mapper.detail("user3");
		
		if (entity == null) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}
	
	
	
	
	

}
