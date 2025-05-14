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
	private long reply_no;

	@Id
	private long board_no;

	private long gid;

	private String status;

	private String content;

	private String created;
}
