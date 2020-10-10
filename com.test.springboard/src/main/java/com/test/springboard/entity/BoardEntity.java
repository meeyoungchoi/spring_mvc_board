package com.test.springboard.entity;

import java.util.Date;

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
@Builder
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardNo;

	private String writer;
	private String title;
	private String content;
	private int readCount;
	private Date createdDate;
	private Date updatedDate;
	


	public BoardEntity() {
	}

	@Builder
	public BoardEntity(Long boardNo, String writer, String title, String content, Date createdDate) {
		this.boardNo = boardNo;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.readCount = 0;
		this.createdDate = createdDate;
	}

	
	public BoardEntity increase() {
		this.readCount += 1;
		return this;
	}

	@Override
	public String toString() {
		return "BoardEntity [boardNo=" + boardNo + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", readCount=" + readCount + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

	public void reWrite(BoardEntity board) {
		this.title = board.getTitle();
		this.content = board.getContent();
	}
}
