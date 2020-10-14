package com.test.springboard.service;



import com.test.springboard.entity.MemberArticleEntity;

public interface IMemberArticleService {
	
	boolean insert(MemberArticleEntity memberArticle);
	
	Iterable<MemberArticleEntity> getMemberArticles();
	

}
