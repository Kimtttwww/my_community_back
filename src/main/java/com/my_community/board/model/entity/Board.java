package com.my_community.board.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
public class Board extends BoardContent {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardNo;

	private String writer;

	private boolean status;

	private Long categoryNo;

	private int views;
}
