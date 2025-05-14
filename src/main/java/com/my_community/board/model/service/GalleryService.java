package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.GalleryDao;
import com.my_community.board.model.dao.GalleryRepository;
import com.my_community.board.model.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryService implements BoardService {

	private final GalleryDao dao;

	private final GalleryRepository repo;

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
