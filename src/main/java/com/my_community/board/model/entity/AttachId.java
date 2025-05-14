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
	private long attach_no;

	@Id
	private long board_no;
}
