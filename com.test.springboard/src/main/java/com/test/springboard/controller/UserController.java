package com.test.springboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.springboard.dto.UserForm;
import com.test.springboard.entity.UserEntity;
import com.test.springboard.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/users")
	public String index(Model model) {
		List<UserEntity> users = service.getUserList();
		model.addAttribute("users", users);
		return "users/index";
	}

	@GetMapping("/users/register")
	public String register() {
		return "users/register";

	}

	@PostMapping("/users/register")
	public String insert(UserForm userForm) {
		System.out.println("users/register");
		System.out.println("userForm: " + userForm.toString());
		service.insert(userForm.toEntity());
		System.out.println("회원가입 완료");

		return "redirect:/users";
	}

	@GetMapping("/users/{userId}")
	public String detail(@PathVariable String userId, Model model) {
		System.out.println("userId: " + userId);
		UserEntity user = service.detail(userId);
		System.out.println("user: " + user.toString());
		model.addAttribute("user", user);
		return "users/show";
	}

	@GetMapping("/users/{userId}/edit")
	public String edit(@PathVariable String userId, Model model) {
		System.out.println("/users/{userId}/edit");
		System.out.println("userId: " + userId);
		UserEntity user = service.detail(userId);
		System.out.println("user: " + user.toString());
		model.addAttribute("user", user);
		return "users/edit";
	}

	@PostMapping("/users/{userId}/update")
	public String update(@PathVariable String userId, UserForm userForm) {
		System.out.println("/users/{userId}/update");
		System.out.println("userId: " + userId);
		System.out.println("userForm: " + userForm.toString());

		service.update(userForm.toEntity(), userId);
		return "redirect:/users/" + userId;
	}

	@GetMapping("/users/{userId}/delete")
	public String delete(@PathVariable String userId) {
		System.out.println("/users/{userId}/delete");
		System.out.println("userId: " + userId);
		service.delete(userId);
		return "redirect:/users";
	}

	@GetMapping("/users/login")
	public String login() {
		return "users/login";
	}

	@PostMapping("/users/login")
	public String loginCheck(UserForm loginForm, HttpServletRequest request) {
		System.out.println("/users/login");
		System.out.println("userForm: " + loginForm.toString());
		UserEntity loginInfo = service.loginCheck(loginForm.toEntity());

		HttpSession session = null;
		session = request.getSession();

		if (loginInfo == null) {
			System.out.println("로그인 실패");
			session.setAttribute("loginFail", null);
			return "users/loginFail";

		} else {
			System.out.println("로그인 결과 loginInfo: " + loginInfo.toString());
			session.setAttribute("loginSuccess", loginInfo.getUserId());
			return "users/loginSuccess";

		}

	}
	
	@GetMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/users";
	}
	
	
	@GetMapping("/users/remove")
	public String remove(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginSuccess");
		model.addAttribute("userId", userId);
		return "redirect:/users/" + userId + "/delete";
	}
	
	
}
