package com.test.springboard.dto;

import com.test.springboard.entity.BoardEntity;

import lombok.Data;

@Data
public class BoardForm {
	private Long boardNo;
	private String title;
	private String content;

	
	public BoardForm(String title, String content) {
		this.title = title;
		this.content = content;
	}

	
	public BoardEntity toEntity() {
		return BoardEntity.builder()
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
