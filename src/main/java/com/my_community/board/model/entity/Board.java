package com.my_community.board.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "tb_board")
public class Board extends BoardContent {

	@Id	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long board_no;

	private String board;

	private Long gid;

	private Boolean status;

	private Integer views;
}
