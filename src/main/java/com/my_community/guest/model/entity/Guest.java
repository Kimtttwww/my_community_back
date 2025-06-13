package com.my_community.guest.model.entity;

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
@Table(name = "tb_guest")
public class Guest extends GuestUnknown {
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long gid;

	private String nickname;

	private boolean status = true;
}
