package com.my_community.board.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.my_community.board.model.entity.Board;

@Mapper
public interface QnaDao extends BoardDao {

	List<Board> getBoardList();

	int getBoardCount();
}
