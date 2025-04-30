package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequiredArgsConstructor
public class BoardController {

	private final BoardService service;

	@GetMapping("boards")
	public ResponseEntity<Out_boardList> getBoardList(@RequestParam String param) {
		List<Board> boardList = service.getBoardList();
		int count = service.getBoardsCount();
		return ResponseEntity.ok(new Out_boardList(0, boardList));
	}

	@GetMapping("board/{boardNo}")
	public ResponseEntity<Board> getBoard(@PathVariable("boardNo") long boardNo) {
		return ResponseEntity.of(service.getBoard(boardNo));
	}

}
