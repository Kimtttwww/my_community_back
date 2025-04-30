package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.BoardRepository;
import com.my_community.board.model.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

//	private final boarddao dao;

	private final BoardRepository repo;

	public List<Board> getBoardList() {
		return null;
	}

	public int getBoardsCount() {
		return 0;
	}

	public Optional<Board> getBoard(long boardNo) {
		return repo.findById(boardNo);
	}
}
