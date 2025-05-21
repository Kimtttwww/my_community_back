package com.my_community.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.entity.MetaBoard;
import com.my_community.board.model.service.MetaBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metaboard")
@RequiredArgsConstructor
public class MetaBoardController {

	private final MetaBoardService service;

	@GetMapping("/")
	public ResponseEntity<List<MetaBoard>> getBoardNameList() {
		return ResponseEntity.ok(service.getBoardNameList());
	}

	@GetMapping("/{domain}")
	public ResponseEntity<MetaBoard> getMethodName(@PathVariable("domain") String domain) {
		return ResponseEntity.ofNullable(service.getMetaBoard(domain));
	}
}
