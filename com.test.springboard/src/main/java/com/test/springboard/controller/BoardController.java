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

import lombok.extern.slf4j.Slf4j;



@Slf4j
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
	public String show(@PathVariable int boardNo, Model model) {
		System.out.println("boardNo: " + boardNo);
		
		BoardEntity entity = boardService.detail(boardNo);
		System.out.println("entity: " + entity.toString());
		model.addAttribute("board", entity);
		return "/boards/show";
	}
	
	
	@GetMapping("/boards/{boardNo}/update")
	public String edit(@PathVariable int boardNo, Model model) {
		BoardEntity board = boardService.detail(boardNo);
		System.out.println("board: " + board.toString());	
		model.addAttribute("board" , board);
		return "/boards/update";
	}
	
	@PostMapping("/boards/{boardNo}/update}")
	public String update(BoardForm boardForm) {
		System.out.println("boardForm: " + boardForm.toString());
		BoardEntity board = boardForm.toEntity();
		System.out.println("update: " + board.toString());
		boardService.update(board);
		return "redirect:/boards/" + board.getBoardNo();
	}
	
	@GetMapping("/boards/{boardNo}/delete")
	public String delete(@PathVariable int boardNo) {
		boardService.delete(boardNo);
		System.out.println(boardNo +  "번글 삭제완료");
		return "redirect:/boards/index";
	}
	
}
