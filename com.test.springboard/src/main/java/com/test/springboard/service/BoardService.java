package com.test.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.springboard.entity.BoardEntity;
import com.test.springboard.repository.BoardRepository;

@Service
public class BoardService implements IBoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	
	
	public void insert(BoardEntity entity) {
		boardRepository.insert(entity);
		
	}



	@Override
	public List<BoardEntity> getBoardList() {
		List<BoardEntity> boards = boardRepository.getBoardList();
		return boards;
	}



	@Override
	public BoardEntity detail(int boardNo) {
		BoardEntity board = boardRepository.detail(boardNo);
		if (board != null) {
			board.increase();
			boardRepository.update(board);
			System.out.println("조회수 증가후 board: " + board.toString());
			System.out.println("=============================================");
		}
		
		
		return boardRepository.detail(boardNo);
	}

	
	public BoardEntity findById(int boardNo) {
		return boardRepository.findById(boardNo);
	}


	@Override
	public void update(BoardEntity board, @PathVariable int boardNo) {
		System.out.println("==============update=====================");
		System.out.println("board: " + board.toString());
		System.out.println("==============before=====================");
		BoardEntity before = boardRepository.findById(boardNo);
		System.out.println("before: " + before.toString());
		before.reWrite(board);
		System.out.println("update 덮어쓴후: " +  before.toString());
		boardRepository.update(before);
	}



	@Override
	public void delete(int boardNo) {
		boardRepository.remove(boardNo);
		
	}
	
	
	
	
}
