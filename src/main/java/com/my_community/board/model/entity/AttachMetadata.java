package com.my_community.board.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@Entity(name = "attach")
@Table(name = "tb_attach")
public class AttachMetadata extends AttachId {

	private boolean status;

	private String origin;

	private String rename;

	private String extend;
}
