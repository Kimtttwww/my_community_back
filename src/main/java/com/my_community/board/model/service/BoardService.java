package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Category;

public interface BoardService {

	List<Board> getBoardList();

	int getBoardCount();

	<T extends Board> Optional<T> getBoard(long boardNo);

	List<Category> getCategoryList();
}
