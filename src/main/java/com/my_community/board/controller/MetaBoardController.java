package com.my_community.board.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.service.MetaBoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/metaboard")
@RequiredArgsConstructor
public class MetaBoardController {

	private final MetaBoardService service;

	@GetMapping("/")
	public ResponseEntity<List<String>> getBoardNameList() {
		return ResponseEntity.ok(service.getBoardNameList());
	}
}
