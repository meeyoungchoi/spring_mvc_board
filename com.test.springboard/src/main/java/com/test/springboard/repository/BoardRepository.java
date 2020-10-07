package com.test.springboard.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.springboard.entity.BoardEntity;

@Repository
public class BoardRepository {

	@Autowired
	private IBoardMapper boardMapper;
	
	public void insert(BoardEntity entity) {
		boardMapper.insert(entity);
	}

	public List<BoardEntity> getBoardList() {
		return boardMapper.getBoardList();
		
	}
}
