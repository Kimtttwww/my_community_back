package com.my_community.board.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my_community.board.model.entity.MetaBoard;

@Repository
public interface MetaBoardRepository extends JpaRepository<MetaBoard, String> {

	MetaBoard findByBoard(String domain);
}
