package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController extends CommonBoardController {

	public NoticeController(NoticeService service) {
		super(service);
	}

}
