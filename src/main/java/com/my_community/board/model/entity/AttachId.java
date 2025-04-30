package com.my_community.board.model.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class AttachId {

	@Id
	private Long attach_no;

	@Id
	private Long board_no;
}
