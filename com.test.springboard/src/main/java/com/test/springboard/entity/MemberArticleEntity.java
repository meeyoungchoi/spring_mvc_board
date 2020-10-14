package com.test.springboard.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class MemberArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long articleNo;
	
	
	private String userId;
	private String title;
	private String content;
	private String userPw;
	private Date writeDate;
	private Date updatedDate;
	private int readCnt;
	
	
	@Builder
	public MemberArticleEntity(String userId, String title, String content, String userPw, int readCnt) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.userPw = userPw;
		this.readCnt = 0;
	}


	@Override
	public String toString() {
		return "MemberArticleEntity [articleNo=" + articleNo + ", userId=" + userId + ", title=" + title + ", content="
				+ content + ", userPw=" + userPw + ", writeDate=" + writeDate + ", updatedDate=" + updatedDate
				+ ", readCnt=" + readCnt + "]";
	}


	public void increase() {
		this.readCnt += 1;
		
	}

	
	
	
	
	
	
	
}
