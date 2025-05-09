package com.my_community.board.model.dto;

import java.util.List;

public record OutBoardList(
		Integer count,
		List<?> boards
) {}
