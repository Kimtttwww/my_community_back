package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.mapper.BoardMapper;
import com.my_community.board.model.service.FaqService;

@RestController
@RequestMapping("/faq")
public class FaqController extends CommonBoardController {

	public FaqController(FaqService service, BoardMapper mapper) {
		super(service, mapper);
	}
}
