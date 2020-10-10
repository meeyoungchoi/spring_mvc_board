package com.test.springboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
}
