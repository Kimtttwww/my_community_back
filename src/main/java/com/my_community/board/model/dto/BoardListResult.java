package com.my_community.board.model.dto;

import java.util.List;

import com.my_community.board.model.entity.Board;

public record BoardListResult(
		int count,
		List<Board> boards
) {}
