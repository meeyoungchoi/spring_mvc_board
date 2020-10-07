package com.test.springboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update(BoardEntity board) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(int boardNo) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
