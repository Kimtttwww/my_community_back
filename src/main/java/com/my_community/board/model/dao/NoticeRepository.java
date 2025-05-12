package com.my_community.board.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_community.board.model.entity.Board;
import com.my_community.board.model.entity.Notice;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

	List<Board> findByStatusTrue();

}
