package com.test.springboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.springboard.dto.BoardForm;
import com.test.springboard.entity.BoardEntity;
import com.test.springboard.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/intro")
	public String intro() {
		return "boards/intro";
	}

	
	@GetMapping("/boards/index")
	public String index(Model model) {
		Iterable<BoardEntity> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		return "boards/index";
	}
	
	
	
	@GetMapping("/boards/new")
	public String newBoard() {
		return "boards/new";
	}
	
	@PostMapping("/boards/new")
	public String create(BoardForm boardForm) {
		System.out.println("/boards/new");
		System.out.println("boardForm: " + boardForm.toString());
		BoardEntity entity = boardForm.toEntity();
		System.out.println("entity: " + entity.toString());
		
		boardService.insert(entity);
		
		return "redirect:/boards/index";
	}
	
	@GetMapping("/boards/{boardNo}")
	public String show(@PathVariable Long boardNo) {
		System.out.println("boardNo: " + boardNo);
		return "/boards/show";
	}
	
}
