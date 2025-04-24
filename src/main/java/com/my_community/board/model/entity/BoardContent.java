package com.my_community.board.model.entity;

import java.sql.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class BoardContent {

	private String title;

	private String content;

	private Date created;
}
