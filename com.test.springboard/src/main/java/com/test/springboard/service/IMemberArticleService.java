package com.test.springboard.service;



import com.test.springboard.entity.MemberArticleEntity;

public interface IMemberArticleService {
	
	boolean insert(MemberArticleEntity memberArticle, String loginId);
	
	Iterable<MemberArticleEntity> getMemberArticles();
	

}
