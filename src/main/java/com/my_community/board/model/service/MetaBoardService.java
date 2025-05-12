package com.my_community.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my_community.board.model.dao.MetaBoardRepository;
import com.my_community.board.model.entity.MetaBoard;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MetaBoardService {

	private final MetaBoardRepository repo;

	public List<String> getBoardNameList() {
		return repo.findAll().stream().map(MetaBoard::getBoard).toList();
	}
}
