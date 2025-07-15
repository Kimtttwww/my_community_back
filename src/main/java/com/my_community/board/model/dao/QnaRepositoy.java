package com.my_community.board.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Qna;

public interface QnaRepositoy extends JpaRepository<Qna, Long> {

	Optional<Board> findByBoardNoAndStatusTrue(long boardNo);
}
