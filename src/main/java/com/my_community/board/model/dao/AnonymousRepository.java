package com.my_community.board.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_community.board.model.entity.Anonymous;
import com.my_community.board.model.entity.Board;

@Repository
public interface AnonymousRepository extends JpaRepository<Anonymous, Long> {

	public Optional<Board> findByBoardNoAndStatusTrue(long boardNo);
}
