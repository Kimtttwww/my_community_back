package com.my_community.guest.model.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;

public record NewGuestArgs(
//		TODO 검증 조건 필요
		@NotBlank @Length(max = 30) String id,

		@NotBlank @Length(min = 6, max = 60) String pwd,

		@NotBlank String nickname) {
}
