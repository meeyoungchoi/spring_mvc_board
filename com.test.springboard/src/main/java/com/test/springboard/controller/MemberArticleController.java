package com.test.springboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.springboard.dto.MemberArticleForm;
import com.test.springboard.entity.UserEntity;
import com.test.springboard.service.MemberArticleService;
import com.test.springboard.service.UserService;

@Controller
public class MemberArticleController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MemberArticleService memberArticleService;
	
	
	
	@PostMapping("/users/write")
	public String insert(MemberArticleForm memberArticle) {
		System.out.println("memberArticeDTO: " + memberArticle.toString());
		
		//service가 비즈니스 로직을 담당한다
		boolean status = memberArticleService.insert(memberArticle.toEntity());
		
		if (status == true) {
			return "redirect:/users/boardList";
		}
		

		System.out.println("post: /users/write");
		return "";
	}
	
	
	
	
	
}
