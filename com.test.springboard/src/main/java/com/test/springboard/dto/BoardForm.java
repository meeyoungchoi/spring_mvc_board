package com.test.springboard.dto;

import java.util.Date;

import com.test.springboard.entity.BoardEntity;

import lombok.Data;

@Data
public class BoardForm {
	private Long boardNo;
	private String writer;
	private String title;
	private String content;
	private Date createdDate;
	private Date updatedDate;

	
	public BoardForm(Long boardNo, String writer, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	

	
	public BoardEntity toEntity() {
		return BoardEntity.builder()
				.writer(writer)
                .content(content)
                .title(title)
                .boardNo(boardNo)
                .build();

	}

	
	@Override
	public String toString() {
		return "BoardForm [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}




	
}
