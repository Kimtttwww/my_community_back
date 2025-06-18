package com.my_community.board.controller;

import com.my_community.board.model.mapper.BoardMapper;
import com.my_community.board.model.service.BoardService;

public abstract class HasReplyController extends CommonBoardController {

	public HasReplyController(BoardService service, BoardMapper mapper) {
		super(service, mapper);
	}
}
