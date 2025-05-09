package com.my_community.board.model.service;

import java.util.List;

import com.my_community.board.model.entity.Board;

public interface BoardService {

	List<Board> getBoardList();

	int getBoardCount();
}
