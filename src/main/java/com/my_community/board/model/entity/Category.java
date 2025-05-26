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
@ToString
@Entity
@Table(name = "tb_category")
public class Category {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryNo;

	private String board;

	private String categoryName;
}
