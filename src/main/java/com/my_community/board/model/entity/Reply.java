package com.my_community.board.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@Table(name = "tb_reply")
public class Reply {

	@Id
	private Long reply_no;

	@Id
	private Long board_no;

	private Long gid;

	private String status;

	private String content;

	private String created;
}
