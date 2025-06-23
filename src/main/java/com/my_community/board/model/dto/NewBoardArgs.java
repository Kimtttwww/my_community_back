package com.my_community.board.model.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record NewBoardArgs(
//		TODO 검증 조건 필요
		Long categoryNo,

		String writer,

		@NotBlank @Length(max = 100) String title,

		@NotBlank @Length(max = 2000) String content) {
}
