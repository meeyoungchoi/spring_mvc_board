package com.test.springboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;

	private String title;
	private String content;
	

	
	
	

	public BoardEntity() {
	}

	@Builder
	public BoardEntity(Long boardNo, String title, String content) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}


	
	
	
}
