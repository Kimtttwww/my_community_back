package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.CategoryRepository;
import com.my_community.board.model.dao.FaqDao;
import com.my_community.board.model.dao.FaqRepository;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.BoardSearchOption;
import com.my_community.board.model.entity.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FaqService implements BoardService {

	private final String domain = "faq";

	private final FaqDao faqDao;

	private final FaqRepository faqRepo;

	private final CategoryRepository categoryRepo;

	@Override
	public List<Board> getBoardList(BoardSearchOption searchOption) {
		return faqDao.getBoardList(searchOption);
	}

	@Override
	public int getBoardCount(BoardSearchOption searchOption) {
		return faqDao.getBoardCount(searchOption);
	}

	@Override
	public <T extends Board> Optional<T> getBoard(long boardNo) {
		return (Optional<T>) faqRepo.findByBoardNoAndStatusTrue(boardNo);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepo.findByBoard(domain);
	}

	@Override
	public void addNewBoard(Board newBoard) {
		throw new UnsupportedOperationException("아직 faq 추가는 허용되지 않습니다..... 아직은");
	}
}
