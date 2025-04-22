package com.my_community.guest.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Guest {
	@Id
	private Long gid;
	private String id;
	private String pwd;
	private String nickname;
	private String status;
}
