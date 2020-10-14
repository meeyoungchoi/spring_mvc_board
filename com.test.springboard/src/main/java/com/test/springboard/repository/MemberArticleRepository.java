package com.test.springboard.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.springboard.entity.MemberArticleEntity;

@Repository
public class MemberArticleRepository {

	@Autowired
	private IMemberArticleMapper meberArticleMapper;
	
	
	public void insert(MemberArticleEntity memberarticle) {
		meberArticleMapper.insert(memberarticle);
		
	}

	
	public List<MemberArticleEntity> getMemberArticles() {
		return meberArticleMapper.getMemberArticles();
	}


	public MemberArticleEntity findById(int articleNo) {
		return meberArticleMapper.findById(articleNo);
	}


	public void update(MemberArticleEntity entity) {
		meberArticleMapper.update(entity);
		
	}
	
	

}
