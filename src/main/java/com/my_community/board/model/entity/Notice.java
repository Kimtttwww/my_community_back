package com.my_community.board.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.ToString;

@ToString(callSuper = true)
@Entity
@Table(name = "vw_notice")
public class Notice extends Board {
}
