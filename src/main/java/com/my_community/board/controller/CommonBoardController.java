package com.my_community.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.my_community.board.model.dto.OutBoardList;
import com.my_community.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CommonBoardController {

	protected final BoardService service;

	@GetMapping("/")
	public ResponseEntity<?> getBoardList() {
		List<?> boards = service.getBoardList();
		int count = service.getBoardCount();
		return ResponseEntity.ok(new OutBoardList(count, boards));
	}
}
