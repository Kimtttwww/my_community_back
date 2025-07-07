package com.my_community.board.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long> {

	List<Board> findByStatusTrue();

	int countByStatusTrue();

	Optional<Board> findByBoardNoAndStatusTrue(long boardNo);
}
