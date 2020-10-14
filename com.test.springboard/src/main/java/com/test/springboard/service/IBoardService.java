package com.test.springboard.service;



import com.test.springboard.entity.BoardEntity;

public interface IBoardService {
	void insert(BoardEntity board);

	Iterable<BoardEntity> getBoardList();

	BoardEntity detail(int boardNo);

	void update(BoardEntity board, int boardNo);

	void delete(int boardNo);

}
