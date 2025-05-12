package com.my_community.board.model.service;

import java.util.List;

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
		return 0;
	}

}
