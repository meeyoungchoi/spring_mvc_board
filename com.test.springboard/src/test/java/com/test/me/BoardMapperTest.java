package com.test.me;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.test.springboard.entity.BoardEntity;
import com.test.springboard.repository.IBoardMapper;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardMapperTest {

	
	@Autowired
	private IBoardMapper mapper;
	
	
	//�Խñ� ��� ���� �׽�Ʈ
	@Test
	public void insertTest() {
		
		for(int i=1; i<=320; i++) {
			BoardEntity board = new BoardEntity();
			board.setTitle("제목" + i);
			board.setContent("내용" + i);
			mapper.insert(board);
		}
		System.out.println("insert완료");
	}
	
	@Test
	public void getListTest() {
		List<BoardEntity> list = mapper.getBoardList();
		
		for (BoardEntity entity : list) {
			System.out.println(entity);
		}
	}
	
	
	@Test
	public void updateTest() {
		BoardEntity board = new BoardEntity();
		board.setBoardNo((long) 2);
		board.setTitle("수정");
		board.setContent("내용수정");
		mapper.update(board);
		System.out.println("update: " + mapper.detail(2));
		
	}
	
	@Test
	public void deleteTest() {
		mapper.delete(6);
		BoardEntity entity = mapper.detail(6);
		if (entity == null) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
	}
	
	
	@Test
	public void show() {
		BoardEntity entity = mapper.detail(3);
		if (entity == null) {
			System.out.println("게시글이 없다");
		} else {
			System.out.println("게시글: " + entity);
		}
		
	}
	
	
}
