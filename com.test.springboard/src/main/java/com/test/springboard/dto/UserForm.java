package com.test.springboard.dto;


import com.test.springboard.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserForm {
	
	private String userName;
	private String userId;
	private String userPw;
	
	public UserEntity toEntity() {
		return  UserEntity.builder()
				.userName(userName)
                .userId(userId)
                .userPw(userPw)
                .build();
	}
	
//	
//	public UserForm(String userId, String userPw) {
//		this.userId = userId;
//		this.userPw = userPw;
//	}
	
	//질문 DTO 객체가 만들어질때도 기본생성자가 필요한가??
	public UserForm() {}
	
		

}
