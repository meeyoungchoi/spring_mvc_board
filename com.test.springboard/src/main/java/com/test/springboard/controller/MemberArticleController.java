package com.test.springboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.springboard.dto.MemberArticleForm;
import com.test.springboard.entity.MemberArticleEntity;

import com.test.springboard.service.MemberArticleService;
import com.test.springboard.service.UserService;

@Controller
public class MemberArticleController {
	

	@Autowired
	private MemberArticleService memberArticleService;
	
		
	@PostMapping("/users/write")
	public String insert(MemberArticleForm memberArticle, HttpSession session) {
		System.out.println("memberArticeDTO: " + memberArticle.toString());
		String loginId = (String) session.getAttribute("loginSuccess");
		//service가 비즈니스 로직을 담당한다
		boolean status = memberArticleService.insert(memberArticle.toEntity(), loginId);
		
		if (status == true) {
			return "redirect:/users/boardList";
		} else {
			return "users/loginFail";
		}

	}
	
	@GetMapping("/users/{articleNo}/detail")
	public String detail(@PathVariable int articleNo, Model model, HttpSession session) {
		System.out.println("Get: /users/{articleNo}/detail " + articleNo);
		MemberArticleEntity memberArticle = memberArticleService.detail(articleNo);
		System.out.println("detail() : " + memberArticle.toString());
		
		String userId = (String) session.getAttribute("loginSuccess");
		
		if (userId != null) {
			model.addAttribute("userId", userId);
		}
		
		
		model.addAttribute("memberArticle", memberArticle);
		return "users/detail_memberArticles";
	}
	
	@GetMapping("/users/{articleNo}/update")
	public String update(@PathVariable int articleNo, Model model) {
		System.out.println("update: " + articleNo);
		MemberArticleEntity memberArticle = memberArticleService.findById(articleNo);
		System.out.println("memberArticle: " + memberArticle.toString());
		model.addAttribute("memberArticle", memberArticle);
		return "users/edit_memberArticles";
	}
	
	@PostMapping("/users/{articleNo}/updatememberarticle")
	public String update(@PathVariable int articleNo, MemberArticleForm memberArticleForm ,  HttpSession session) {
		System.out.println("post  /users/{articleNo}/update: memberArticleForm " + memberArticleForm.toString());
		System.out.println("articleNo: " + articleNo);
		String loginId  = (String) session.getAttribute("loginSuccess");
		
		boolean status = memberArticleService.update(memberArticleForm.toEntity(), articleNo, loginId);
		if (status == true) {
			return "redirect:/users/" + articleNo + "/detail";
		} else {
			return "users/wrong_pw";
		}
		
	}
	
	
	@GetMapping("/users/delete/{articleNo}")
	public String delete(@PathVariable int articleNo, Model model) {
		model.addAttribute("articleNo", articleNo);
		return "users/delete";
	}
	
	@PostMapping("/users/{articleNo}/remove")
	public String remove(@PathVariable int articleNo, @RequestParam(value="userPw") String userPw, HttpSession session) {
		System.out.println("/users/${articleNo}/remove : POST " );
		System.out.println("articleNo: " + articleNo);
		System.out.println("userPw: " + userPw);
		
		String userId =  (String) session.getAttribute("loginSuccess");
		
		boolean status = memberArticleService.remove(articleNo, userPw, userId);
		
		if (status == true) {
			return "redirect:/users/boardList";
		} else {
			return "users/loginFail";
		}
	}
	
	
}
