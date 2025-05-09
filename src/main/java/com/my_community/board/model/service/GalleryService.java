package com.my_community.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my_community.board.model.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GalleryService implements BoardService {

	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
