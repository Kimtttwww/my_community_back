package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.AnonymousDao;
import com.my_community.board.model.dao.AnonymousRepository;
import com.my_community.board.model.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnonymousService implements BoardService {

	private final AnonymousDao dao;

	private final AnonymousRepository repo;

	@Override
	public List<Board> getBoardList() {
		return repo.findByStatusTrue();
	}

	@Override
	public int getBoardCount() {
		return repo.countByStatusTrue();
	}

	@Override
	public <T extends Board> Optional<T> getBoard(long boardNo) {
		return (Optional<T>) repo.findById(boardNo);
	}
}
