package com.my_community.board.controller;

import org.springframework.web.bind.annotation.RestController;

import com.my_community.board.model.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

	private BoardService service;

	
}
