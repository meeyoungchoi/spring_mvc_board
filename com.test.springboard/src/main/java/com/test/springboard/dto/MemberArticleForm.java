package com.test.springboard.dto;

import com.test.springboard.entity.MemberArticleEntity;

public class MemberArticleForm {
	private String userId;
	private String title;
	private String content;
	private String userPw;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public MemberArticleForm(String userId, String title, String content, String userPw) {
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.userPw = userPw;
	}
	
	@Override
	public String toString() {
		return "MemberArticleForm [userId=" + userId + ", title=" + title + ", content=" + content + ", userPw="
				+ userPw + "]";
	}
	public MemberArticleEntity toEntity() {	
		return MemberArticleEntity.builder()
				.title(title)
				.content(content)
				.userId(userId)
				.userPw(userPw)
				.build();
	}
	
	
	
	
	
	
	
}
