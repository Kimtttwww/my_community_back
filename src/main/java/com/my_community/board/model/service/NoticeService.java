package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.NoticeDao;
import com.my_community.board.model.dao.NoticeRepository;
import com.my_community.board.model.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService implements BoardService {

	private final NoticeDao dao;

	private final NoticeRepository repo;

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
		return (Optional<T>) repo.findByBoardNoAndStatusTrue(boardNo);
	}
}
