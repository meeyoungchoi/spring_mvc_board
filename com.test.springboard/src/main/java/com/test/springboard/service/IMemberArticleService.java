package com.test.springboard.service;

import java.util.List;

import com.test.springboard.entity.MemberArticleEntity;

public interface IMemberArticleService {
	
	boolean insert(MemberArticleEntity memberArticle);
	
	List<MemberArticleEntity> getMemberArticles();
	

}
