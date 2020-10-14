package com.test.springboard.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.springboard.entity.MemberArticleEntity;
import com.test.springboard.entity.UserEntity;
import com.test.springboard.repository.MemberArticleRepository;

@Service
public class MemberArticleService implements IMemberArticleService{

	@Autowired
	private MemberArticleRepository memberArticleRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public boolean insert(MemberArticleEntity memberArticle) {
		boolean status = false;
		System.out.println("MemberArticleService insert() memberArticle: " + memberArticle.toString());
		
		//아이디를 사용하여 mvc_user 테이블에서 해당 아이디를 갖고있는 Entity를 꺼내온다
		UserEntity user = userService.detail(memberArticle.getUserId());
		
		System.out.println("MemberArticleSerivce insert() UserService user: " + user.toString());
		
		//memberArticle Entity와 user Entity의 id와 pw비교
		if (memberArticle.getUserId().equals(user.getUserId()) && memberArticle.getUserPw().equals(user.getUserPw())) {
			System.out.println("작성자의 아이디와 비밀번호가 올바릅니다.");
			memberArticleRepository.insert(memberArticle);
			status = true;
			System.out.println("status: " + status);
			return status;
		}  else if (memberArticle.getUserPw().equals(null)) {
			System.out.println("작성자의 아이디와 비밀번호가 올바르지 않습니다.");
			status = false;
		}
		
		return status;
		
		
	}

	@Override
	public List<MemberArticleEntity> getMemberArticles() {
		return memberArticleRepository.getMemberArticles();
	}

	public MemberArticleEntity detail(int articleNo) {
		MemberArticleEntity entity = memberArticleRepository.findById(articleNo);
		
		if (entity != null) {
			entity.increase();
			System.out.println("조회수 증가후: " + entity.toString());
			memberArticleRepository.update(entity);
		}
		
		return entity;
		
	}
	
}
