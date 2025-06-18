package com.my_community.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.BoardSearchOption;

@Mapper
public interface AnonymousDao {
	List<Board> getBoardList(BoardSearchOption searchOption);

	int getBoardCount(BoardSearchOption searchOption);
}
