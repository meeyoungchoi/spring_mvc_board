package com.test.springboard.repository;



import java.util.List;

import com.test.springboard.entity.BoardEntity;

public interface IBoardMapper {
	void insert(BoardEntity board);
	
	List<BoardEntity> getBoardList();
	
	BoardEntity detail(int boardNo);
	
	void update(BoardEntity board);
	
	void delete(int boardNo);

}
