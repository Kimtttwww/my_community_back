package com.my_community.board.model.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

	public List<Board> findByStatusTrue();

	public int countByStatusTrue();

	public Optional<Board> findByBoardNoAndStatusTrue(long boardNo);
}
