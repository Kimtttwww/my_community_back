package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.mapper.BoardMapper;
import com.my_community.board.model.service.AnonymousService;

@RestController
@RequestMapping("/anonymous")
public class AnonymousController extends CommonBoardController {

	public AnonymousController(AnonymousService service, BoardMapper mapper) {
		super(service, mapper);
	}
}
