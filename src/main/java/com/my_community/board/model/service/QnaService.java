package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.CategoryRepository;
import com.my_community.board.model.dao.QnaDao;
import com.my_community.board.model.dao.QnaRepositoy;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.BoardSearchOption;
import com.my_community.board.model.entity.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaService implements BoardService {

	private String domain = "qna";

	private final QnaDao qnaDao;

	private final QnaRepositoy qnaRepo;

	private final CategoryRepository categoryRepo;

	@Override
	public List<Board> getBoardList(BoardSearchOption searchOption) {
		return qnaDao.getBoardList();
	}

	@Override
	public int getBoardCount(BoardSearchOption searchOption) {
		return qnaDao.getBoardCount();
	}

	@Override
	public <T extends Board> Optional<T> getBoard(long boardNo) {
		return (Optional<T>) qnaRepo.findByBoardNoAndStatusTrue(boardNo);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepo.findByBoard(domain);
	}

	@Override
	public void addNewBoard(Board newBoard) {
		// TODO qna 글 작성 기능 필요

	}
}
