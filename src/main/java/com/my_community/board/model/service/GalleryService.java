package com.my_community.board.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.CategoryRepository;
import com.my_community.board.model.dao.GalleryDao;
import com.my_community.board.model.dao.GalleryRepository;
import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.BoardSearchOption;
import com.my_community.board.model.entity.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryService implements BoardService {

	private final String domain = "Gallery";

	private final GalleryDao galleryDao;

	private final GalleryRepository galleryRepo;

	private final CategoryRepository categoryRepo;

	@Override
	public List<Board> getBoardList(BoardSearchOption searchOption) {
		return galleryDao.getBoardList(searchOption);
	}

	@Override
	public int getBoardCount(BoardSearchOption searchOption) {
		return galleryRepo.countByStatusTrue();
	}

	@Override
	public <T extends Board> Optional<T> getBoard(long boardNo) {
		return (Optional<T>) galleryRepo.findByBoardNoAndStatusTrue(boardNo);
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryRepo.findByBoard(domain);
	}
}
