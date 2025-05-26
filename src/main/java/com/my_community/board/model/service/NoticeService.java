package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.CategoryRepository;
import com.my_community.board.model.dao.NoticeDao;
import com.my_community.board.model.dao.NoticeRepository;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeService implements BoardService {

	private final String domain = "Notice";

	private final NoticeDao noticeDao;

	private final NoticeRepository noticeRepo;

	private final CategoryRepository categoryRepo;

	@Override
	public List<Board> getBoardList() {
		return noticeRepo.findByStatusTrue();
	}

	@Override
	public int getBoardCount() {
		return noticeRepo.countByStatusTrue();
	}

	@Override
	public <T extends Board> Optional<T> getBoard(long boardNo) {
		return (Optional<T>) noticeRepo.findByBoardNoAndStatusTrue(boardNo);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepo.findByBoard(domain);
	}
}
