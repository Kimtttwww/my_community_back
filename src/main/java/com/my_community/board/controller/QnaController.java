package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.mapper.BoardMapper;
import com.my_community.board.model.service.QnaService;

@RestController
@RequestMapping("/qna")
public class QnaController extends CommonBoardController {

	public QnaController(QnaService service, BoardMapper mapper) {
		super(service, mapper);
	}
}
