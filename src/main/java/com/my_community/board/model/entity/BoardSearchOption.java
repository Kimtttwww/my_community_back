package com.my_community.board.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardSearchOption {
//	TODO 검색 기능 추가시 필요한 것

	private int perPage;
	private int currentPage;
	private int offset;

	public BoardSearchOption() {
		super();
		this.perPage = 10;
		this.currentPage = 1;
	}
}
