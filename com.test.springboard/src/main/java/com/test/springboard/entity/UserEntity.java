package com.test.springboard.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@Entity
@NoArgsConstructor
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userNo;
	
	private String userName;
	private String userId;
	private String userPw;
	
	
	@Builder
	public UserEntity (String userName, String userId, String userPw) {
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
	}
	
	
	
	
	@Override
	public String toString() {
		return "UserEntity [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPw=" + userPw
				+ "]";
	}




	public void rewrite(UserEntity user) {
		this.userName = user.getUserName();
		this.userId = user.getUserId();
		this.userPw = user.getUserPw();
		
	}
	
	
	
	
	
	
	
	
}
