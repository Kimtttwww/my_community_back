package com.my_community.board.model.dao;

import java.util.List;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.BoardSearchOption;

public interface BoardDao {

	List<Board> getBoardList(BoardSearchOption searchOption);

	int getBoardCount(BoardSearchOption searchOption);

	void addNewBoard(Board newBoard);
}
