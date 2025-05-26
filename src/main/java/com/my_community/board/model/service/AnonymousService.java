package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.AnonymousDao;
import com.my_community.board.model.dao.AnonymousRepository;
import com.my_community.board.model.dao.CategoryRepository;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnonymousService implements BoardService {

	private final String domain = "Anonymous";

	private final AnonymousDao anonymousDao;

	private final AnonymousRepository anonymousRepo;

	private final CategoryRepository categoryRepo;

	@Override
	public List<Board> getBoardList() {
		return anonymousRepo.findByStatusTrue();
	}

	@Override
	public int getBoardCount() {
		return anonymousRepo.countByStatusTrue();
	}

	@Override
	public <T extends Board> Optional<T> getBoard(long boardNo) {
		return (Optional<T>) anonymousRepo.findByBoardNoAndStatusTrue(boardNo);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepo.findByBoard(domain);
	}
}
