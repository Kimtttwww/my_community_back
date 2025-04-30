package com.my_community.board.controller;

import java.util.List;

import com.my_community.board.model.entity.Board;

public record Out_boardList(
		int count,
		List<Board> boardList
) {}
