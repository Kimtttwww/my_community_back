package com.my_community.board.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my_community.board.model.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	public void findby();
}
