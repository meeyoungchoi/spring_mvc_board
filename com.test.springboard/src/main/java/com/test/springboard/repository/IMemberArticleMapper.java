package com.test.springboard.repository;



import java.util.List;

import com.test.springboard.entity.MemberArticleEntity;

public interface IMemberArticleMapper {	
	void insert(MemberArticleEntity memberarticle);
	
	List<MemberArticleEntity> getMemberArticles();
	
	MemberArticleEntity findById(int articleNo);

	void update(MemberArticleEntity entity);

}
