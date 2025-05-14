package com.my_community.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.my_community.board.model.dto.BoardListResult;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CommonBoardController {

	protected final BoardService service;

	@GetMapping("/")
	public ResponseEntity<BoardListResult> getBoardList() {
		List<Board> boards = service.getBoardList();
		int count = service.getBoardCount();
		return ResponseEntity.ok(new BoardListResult(count, boards));
	}
	
	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> getBoard(@PathVariable("boardNo") long boardNo) {
		return ResponseEntity.of(service.getBoard(boardNo));
	}
}
