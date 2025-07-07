package com.my_community.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.my_community.board.model.dto.BoardListResult;
import com.my_community.board.model.dto.BoardSearchOptionArgs;
import com.my_community.board.model.dto.NewBoardArgs;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Category;
import com.my_community.board.model.mapper.BoardMapper;
import com.my_community.board.model.service.BoardService;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class CommonBoardController {

	protected final BoardService service;

	private final BoardMapper mapper;

	@GetMapping("/")
	public ResponseEntity<BoardListResult> getBoardList(@ModelAttribute BoardSearchOptionArgs args) {
		List<Board> boards = service.getBoardList(mapper.toEntity(args));
		int count = service.getBoardCount(mapper.toEntity(args));
		return ResponseEntity.ok(new BoardListResult(count, boards));
	}

	@GetMapping("/{boardNo}")
	public ResponseEntity<Board> getBoard(@Positive @PathVariable("boardNo") long boardNo) {
//		TODO 조회시 조회수 증가 기능 추가 필요
		return ResponseEntity.of(service.getBoard(boardNo));
	}

	@GetMapping("/category")
	public ResponseEntity<List<Category>> getCategoryList() {
		return ResponseEntity.ofNullable(service.getCategoryList());
	}

	@PostMapping("/write")
	public ResponseEntity<?> addNewBoard(@RequestBody NewBoardArgs newBoard) {
		service.addNewBoard(mapper.toEntity(newBoard));
		return ResponseEntity.noContent().build();
	}
}
